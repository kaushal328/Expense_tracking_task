package com.example.expense.tracking.Controller;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.expense.tracking.Response;
import com.example.expense.tracking.DAO.LoginDTO;
import com.example.expense.tracking.DAO.UserRegistrationDTO;
import com.example.expense.tracking.Entity.Users;
import com.example.expense.tracking.Service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDTO dto) {
        String result = userService.register(dto);
        System.out.println(result);
        if ("success".equalsIgnoreCase(result)) {
            return ResponseEntity.ok("Registration successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + result);
        }
    }

    @PostMapping("login")
    public ResponseEntity<Response<String>> login(@Valid @RequestBody LoginDTO dto, HttpSession session) {
        Users user = userService.login(dto);
       // System.out.println(user);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Response<>(false, "Invalid credentials", null));
        }
        session.setAttribute("loggedInUser", user.getId());
       return null;
    }


}
