package com.quiz.dto;

import java.util.List;

import lombok.Data;

@Data
public class QuizSubmission {
private String userId;
private String username;
private Long quizId;
List<String> answers;
    
}
