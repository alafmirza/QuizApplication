package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.quiz.dao.QuestionRepository;
import com.quiz.dao.QuizRepository;
import com.quiz.dao.ResultRepository;
import com.quiz.dto.QuiestionResponseDTO;
import com.quiz.dto.QuizSubmission;
import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import com.quiz.entities.Result;



@Component
public class QuizService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    ResultRepository resultRepository;

    // get titles
    public List<Quiz> getTitles(){
        return quizRepository.findAll();
    }

// get questions 
     public  List<QuiestionResponseDTO> getQuestions(Long quizId){
        List<Question> questionList = questionRepository.findByQuizId(quizId);

 return  questionList.stream().map(e->new QuiestionResponseDTO(
    e.getQuestion(),
    List.of(
        e.getOptionA(),
        e.getOptionB(),
        e.getOptionC(),
        e.getOptionD()
   ))).toList();    
    }

//submition

public int calculateScore(QuizSubmission submission){

   Long Id = submission.getQuizId();
  List<Question> questionList = questionRepository.findByQuizId(Id);
  int score = 0;
  for (int i = 0; i < Math.min(questionList.size(),submission.getAnswers().size()); i++)
    {
   String correctAnswer= questionList.get(i).getCorrectAnswer();
   String userAnswer = submission.getAnswers().get(i);
   if(userAnswer.equalsIgnoreCase(correctAnswer)){
    score++;
   }
  }
        Result result = new Result();
        result.setUserId(submission.getUserId());
        result.setUsername(submission.getUsername());
        result.setQuizId(submission.getQuizId());
        result.setScore(score);
        resultRepository.save(result);
        return score;
}  


}