package com.example.loginappas.dto;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {
    private String login;
    private String haslo;
    private String haslo2;

    public RegistrationDTO(String login, String haslo, String haslo2) {
        this.login = login;
        this.haslo = haslo;
        this.haslo2 = haslo2;
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

    public String getHaslo2() {
        return haslo2;
    }

    public void setHaslo2(String haslo2) {
        this.haslo2 = haslo2;
    }

    public  boolean isHasloEquals(){

        return
                haslo!= null &&!haslo.isEmpty()
                        && haslo2!=null && !haslo2.isEmpty()
                            && haslo2.equals(haslo);
    }





public boolean hasFieldsFilled(){
        return
                login!= null && !login.isEmpty()
                         && haslo!= null && ! haslo.isEmpty()
                                 && haslo2!= null && ! haslo2.isEmpty();
}

}
