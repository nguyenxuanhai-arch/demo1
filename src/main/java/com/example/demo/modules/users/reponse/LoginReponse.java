package com.example.demo.modules.users.reponse;

import com.example.demo.modules.users.dtos.UserDTO;

public class LoginReponse {
    private final String token;
    private final UserDTO user;

    public LoginReponse(String token, UserDTO user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public UserDTO getUser() {
        return user;
    }

}
