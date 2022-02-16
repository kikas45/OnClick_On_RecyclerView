package com.example.recyclerview_intro;


import java.io.Serializable;

public class UserModel implements Serializable {
    String username;

    public UserModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
