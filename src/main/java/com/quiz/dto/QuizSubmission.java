package com.quiz.dto;
import java.util.Map;

import lombok.Data;

@Data
public class QuizSubmission {
private String userId;
private String username;
private Long quizId;
Map<String,String> answers;
    
}
