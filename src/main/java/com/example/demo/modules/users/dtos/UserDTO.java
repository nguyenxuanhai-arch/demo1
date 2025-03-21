package com.example.demo.modules.users.dtos;

public class UserDTO {
    private final Long id;
    private final String email;

    public UserDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
