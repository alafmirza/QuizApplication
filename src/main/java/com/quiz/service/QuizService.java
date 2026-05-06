package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.QuestionRepository;
import com.quiz.entities.Question;


@Service
public class QuizService {
    @Autowired
    QuestionRepository questionRepository;


      List<Question> getQuestions(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }

}
