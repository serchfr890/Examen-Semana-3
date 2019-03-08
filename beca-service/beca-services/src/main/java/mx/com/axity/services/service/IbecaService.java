package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;

import java.util.List;

public interface IbecaService {
    List<LoginDO> getLogins();
    LoginDO getLogin(Long id);
    void saveLogin(LoginDO loginDO);
    void updateLogin(LoginDO loginDO);
    void deleteLogin(Long id);
}
