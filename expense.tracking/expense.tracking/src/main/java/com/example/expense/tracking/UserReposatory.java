package com.example.expense.tracking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expense.tracking.Entity.Users;

import java.util.Optional;

@Repository
public interface UserReposatory extends JpaRepository<Users,Long> {

     Optional<Users> findByUsername(String user_name);

    boolean existsByEmail(String email);
}
