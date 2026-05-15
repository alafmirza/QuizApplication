package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.quiz.dao.QuestionRepository;
import com.quiz.dao.QuizRepository;
import com.quiz.entities.Question;
import com.quiz.entities.Quiz;



@Component
public class QuizService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    // get titles
    public List<Quiz> getTitles(){
        return quizRepository.findAll();
    }

// get questions 
     public  List<Question> getQuestions(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }



   
}
