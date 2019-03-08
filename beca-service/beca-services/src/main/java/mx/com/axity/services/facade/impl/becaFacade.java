package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired
    private IbecaService becaService;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<LoginTO> getAllLogins() {
        List<LoginDO> loginDOList = this.becaService.getLogins();
        Type loginTOType = new TypeToken<List<LoginTO>>() {}.getType();
        List<LoginTO> loginTOList = this.modelMapper.map(loginDOList, loginTOType );
        return loginTOList;
    }

    @Override
    public LoginTO getLoginById(Long id) {
        LoginDO loginDO = this.becaService.getLogin(id);
        LoginTO loginTO = this.modelMapper.map(loginDO, LoginTO.class);
        return loginTO;
    }

    @Override
    public void createLogin(LoginTO loginTO) {
        LoginDO loginDO = this.modelMapper.map(loginTO, LoginDO.class);
        this.becaService.saveLogin(loginDO);
    }

    @Override
    public void updateLogin(LoginTO loginTO) {
        LoginDO loginDO = this.modelMapper.map(loginTO, LoginDO.class);
        this.becaService.updateLogin(loginDO);
    }

    @Override
    public void deleteLoginUd(Long id) {
        this.becaService.deleteLogin(id);
    }
}
