package com.example.demo.modules.users.services.impl;

import com.example.demo.modules.users.services.interfaces.UserServiceInterface;
import com.example.demo.services.BaseService;
import org.springframework.stereotype.Service;

import com.example.demo.modules.users.requests.LoginRequest;
import com.example.demo.modules.users.resources.LoginResource;
import com.example.demo.modules.users.resources.UserResource;

@Service
public class UserService extends BaseService implements UserServiceInterface {
    @Override
    public LoginResource login(LoginRequest request) {
        try {
            //String email = request.getEmail();
            //String password = request.getPassword();

            String token = "random_token";
            UserResource user = new UserResource(1L, "database_email@gmail.com");

            return new LoginResource(token, user);
        } catch (Exception e)
        {
            throw new RuntimeException("Có vấn đề xảy ra khi đăng nhập");
        }
    }
}
