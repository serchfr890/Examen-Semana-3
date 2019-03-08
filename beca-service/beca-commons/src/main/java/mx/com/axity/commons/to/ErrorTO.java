package mx.com.axity.commons.to;

import java.io.Serializable;

public class ErrorTO implements Serializable {

    private  Long erroCode;
    private String erroMessage;

    public Long getErroCode() {
        return erroCode;
    }

    public void setErroCode(Long erroCode) {
        this.erroCode = erroCode;
    }

    public String getErroMessage() {
        return erroMessage;
    }

    public void setErroMessage(String erroMessage) {
        this.erroMessage = erroMessage;
    }
}
