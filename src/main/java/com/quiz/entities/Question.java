package com.quiz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String question;
    private String OptionA;
    private String OptionB ;
    private String OptionC;
    private String OptionD;

    private String CorrectAnswer;
    @ManyToOne
    private Quiz quiz;


}
