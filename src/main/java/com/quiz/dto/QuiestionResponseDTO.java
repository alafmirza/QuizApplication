package com.quiz.dto;

import java.util.List;


public class QuiestionResponseDTO {
    private Long Id;
    private String question;
    private List<String> options;
    
    public QuiestionResponseDTO(Long id, String question, List<String> options) {
        Id = id;
        this.question = question;
        this.options = options;
    }

    public Long getId() {
        return Id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    
    public QuiestionResponseDTO(){
        
    }
}