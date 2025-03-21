package com.example.demo.modules.users.services.impl;

import com.example.demo.modules.users.dtos.UserDTO;
import com.example.demo.modules.users.services.interfaces.UserServiceInterface;
import com.example.demo.services.BaseService;
import org.springframework.stereotype.Service;

import com.example.demo.modules.users.reponse.LoginReponse;
import com.example.demo.modules.users.request.LoginRequest;

@Service
public class UserService extends BaseService implements UserServiceInterface {
    @Override
    public LoginReponse login(LoginRequest request) {
        try {
            //String email = request.getEmail();
            //String password = request.getPassword();

            String token = "random_token";
            UserDTO user = new UserDTO(1L, "database_email@gmail.com");

            return new LoginReponse(token, user);
        } catch (Exception e)
        {
            throw new RuntimeException("Có vấn đề xảy ra khi đăng nhập");
        }
    }
}
