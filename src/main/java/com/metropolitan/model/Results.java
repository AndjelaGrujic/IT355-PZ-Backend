package com.metropolitan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metropolitan.model.quiz.Quiz;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

    public Results(Long id, User user, Quiz quiz, Double points) {
        this.id = id;
        this.user = user;
        this.quiz = quiz;
        this.points = points;
    }
    public Results( User user, Quiz quiz, Double points) {
        this.user = user;
        this.quiz = quiz;
        this.points = points;
    }
    public Results(){

    }

    private Double points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
}
