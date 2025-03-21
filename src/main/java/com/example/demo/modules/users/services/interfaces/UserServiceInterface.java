package com.example.demo.modules.users.services.interfaces;

import com.example.demo.modules.users.reponses.LoginReponse;
import com.example.demo.modules.users.requests.LoginRequest;

public interface UserServiceInterface {
    LoginReponse login(LoginRequest request);
}
