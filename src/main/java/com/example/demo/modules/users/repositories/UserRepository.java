package com.example.demo.modules.users.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modules.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
