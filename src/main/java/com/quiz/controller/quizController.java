package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class quizController {
    @Autowired
   QuizService quizService;
   
   //get titles
   @GetMapping("/Titles")
public List<Quiz> getAllTitles(){
    return quizService.getTitles();
}

   //get questions 

    @GetMapping("/{quizId}")
    public List<Question> getAllQuestions(@PathVariable("quizId") Long quizId){
        return quizService.getQuestions(quizId);
    }
    

    //submit questions
    
}
