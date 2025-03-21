package com.example.demo.modules.users.services.interfaces;

import com.example.demo.modules.users.dtos.request.LoginRequest;
import com.example.demo.modules.users.dtos.reponse.LoginReponse;

public interface UserServiceInterface {
    LoginReponse login(LoginRequest request);
}
