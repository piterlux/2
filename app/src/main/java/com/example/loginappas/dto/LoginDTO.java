package com.example.loginappas.dto;

import java.io.Serializable;

public class LoginDTO  implements Serializable {
    private String login;
    private String haslo;

    public LoginDTO(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
