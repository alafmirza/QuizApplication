package com.quiz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.dto.QuiestionResponseDTO;
import com.quiz.dto.QuizSubmission;
import com.quiz.entities.Quiz;
import com.quiz.service.QuizService;

@Controller
public class PageController {
    @Autowired
    private QuizService quizService;
    
    //home page
    @GetMapping("/")
    public String home(Model model){
       List<Quiz> titleList = quizService.getTitles();
       model.addAttribute("quizzes", titleList);
        return "index.html";

    }
    //quize page
    @GetMapping("/quiz-page/{quizId}")
    public String quiz(@PathVariable ("quizId") Long quizId , Model model){
        List<QuiestionResponseDTO> allquestions = quizService.getQuestions(quizId);
        model.addAttribute("questions", allquestions);
        model.addAttribute("quizId", quizId);
        return "quiz.html";
    }

    //submit page
    @PostMapping("/submit-quiz")
    public String submit(Model model,
         @RequestParam Long quizId,
        @RequestParam String userId ,
        @RequestParam String username,
        @RequestParam Map<String,String> answers
    ){
        QuizSubmission quizSubmission = new QuizSubmission();
        quizSubmission.setUserId(userId);
        quizSubmission.setQuizId(quizId);
        quizSubmission.setUsername(username);
        quizSubmission.setAnswers(answers);
        int score = quizService.calculateScore(quizSubmission);

        model.addAttribute("score", score);

        return "result.html";
    }

    //login page 
    @GetMapping("/login")
    public String loginPage(){
        return "login.html";
    }


    //signup page 
    @GetMapping("/signup")
    public String signupPage(){
        return "signup.html";
    }


}
