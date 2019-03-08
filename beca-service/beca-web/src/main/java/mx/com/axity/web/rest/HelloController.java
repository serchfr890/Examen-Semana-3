package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;

    @RequestMapping(value = "/logins", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LoginTO>> getAllUsers() {
        LOG.info("Se obtienen todos los logins");
        List<LoginTO> login = this.IbecaFacade.getAllLogins();
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getLoginById(@RequestParam(value = "id") Long id){
        LOG.info("GET LOGIN BY ID");
        LOG.info(id);
        LoginTO loginTO = this.IbecaFacade.getLoginById(id);
        return new ResponseEntity(loginTO, HttpStatus.OK);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveLogin(@RequestBody LoginTO loginTO) {
        this.IbecaFacade.createLogin(loginTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/loginp", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity loginp(
            @RequestParam(value = "user_name") String user_name,
            @RequestParam(value = "password") String password){
        if(this.IbecaFacade.login(user_name, password)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateLogin(@RequestBody LoginTO loginTO) {
        LOG.info("Update Login");
        this.IbecaFacade.updateLogin(loginTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete user
    @RequestMapping(value = "/login", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity loginDelete(@RequestParam(value = "id") Long id) {
        LOG.info("Delete Login By Id");
        LOG.info(id);
        this.IbecaFacade.deleteLoginUd(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
