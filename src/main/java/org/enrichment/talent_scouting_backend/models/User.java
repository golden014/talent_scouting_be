package org.enrichment.talent_scouting_backend.models;

import org.enrichment.talent_scouting_backend.enums.Role;

public class User {
    private org.enrichment.talent_scouting_backend.enums.Role role;
    private String login;
    private String token;
    private String ID;
    private String password;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
