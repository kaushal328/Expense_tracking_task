package com.example.expense.tracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense.tracking.UserReposatory;
import com.example.expense.tracking.DAO.LoginDTO;
import com.example.expense.tracking.DAO.UserRegistrationDTO;
import com.example.expense.tracking.Entity.Users;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserReposatory userRepo;
    public String register(UserRegistrationDTO dto) {
        if (userRepo.findByUsername(dto.getUsername()).isPresent()) {
              throw new RuntimeException("User already exists!");
        }
        if (userRepo.existsByEmail(dto.getEmail())) {
              throw new RuntimeException("User already registered with this email!");
        }
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFull_name(dto.getFull_name());
        user.setEmail(dto.getEmail());
        userRepo.save(user);
        return "success";
    }
    public Users login(LoginDTO dto) {
        Optional<Users> optionalUser = userRepo.findByUsername(dto.getUsername());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        Users user = optionalUser.get();
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return user;
    }





}
