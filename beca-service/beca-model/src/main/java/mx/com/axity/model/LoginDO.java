package mx.com.axity.model;

import javax.persistence.*;

@Entity
@Table(name = "logins", schema = "public")

public class LoginDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Por si tiene autoIncremeny
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String user;
    @Column(name = "password")
    private String password;

    public LoginDO() {
    }

    public LoginDO(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
