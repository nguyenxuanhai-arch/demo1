package com.example.demo.modules.users.services.interfaces;

import com.example.demo.modules.users.requests.LoginRequest;
import com.example.demo.modules.users.resources.LoginResource;

public interface UserServiceInterface {
    LoginResource login(LoginRequest request);
}
