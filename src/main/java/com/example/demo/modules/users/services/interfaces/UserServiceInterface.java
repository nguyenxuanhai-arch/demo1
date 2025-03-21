package com.example.demo.modules.users.services.interfaces;

import com.example.demo.modules.users.reponse.LoginReponse;
import com.example.demo.modules.users.request.LoginRequest;

public interface UserServiceInterface {
    LoginReponse login(LoginRequest request);
}
