package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.entities.User;


@Repository
public interface UserReopsitory extends JpaRepository<User,Long> {
    
     User findByUsername(String username);
}
