package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.entities.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {
    
}
