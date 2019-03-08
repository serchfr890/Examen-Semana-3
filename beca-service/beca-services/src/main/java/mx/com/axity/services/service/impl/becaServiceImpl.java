package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.LoginDAO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    LoginDAO loginDAO;

    @Override
    public List<LoginDO> getLogins() {
        List<LoginDO> loginDOList = (List<LoginDO>) this.loginDAO.findAll();
        return loginDOList;
    }

    @Override
    public LoginDO getLogin(Long id) {
        LoginDO loginDO = this.loginDAO.findById(id).get();
        return loginDO;
    }

    @Override
    public void saveLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

    @Override
    public void updateLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

    @Override
    public void deleteLogin(Long id) {
        this.loginDAO.deleteById(id);
    }
}
