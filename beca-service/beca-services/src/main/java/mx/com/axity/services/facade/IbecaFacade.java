package mx.com.axity.services.facade;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;

import java.util.List;

public interface IbecaFacade {
    List<LoginTO> getAllLogins();
    LoginTO getLoginById(Long id);
    void createLogin(LoginTO loginTO);
    void updateLogin(LoginTO loginTO);
    void deleteLoginUd(Long id);
}
