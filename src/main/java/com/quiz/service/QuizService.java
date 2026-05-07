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

 // find questions 
      List<Question> getQuestions(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }

    //submit answre

    int  calculateScore(List<Question> questions, List<String> answers){
    int score=0;
    for(int i=0;i<questions.size();i++){
        if(questions.get(i).getCorrectAnswer().equalsIgnoreCase(answers.get(i))){
            score++;
        }
    }

        return score;
    }
}
