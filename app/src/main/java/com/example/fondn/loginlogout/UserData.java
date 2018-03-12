package com.example.fondn.loginlogout;

/**
 * Created by fondn on 3/12/2018.
 */

public class UserData {
    private String name,email,pasword,username;

    public UserData() {
    }

    public UserData(String name, String email, String pasword, String username) {
        this.name = name;
        this.email = email;
        this.pasword = pasword;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
