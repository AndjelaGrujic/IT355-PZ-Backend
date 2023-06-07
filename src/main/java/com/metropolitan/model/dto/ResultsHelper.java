package com.metropolitan.model.dto;


public class ResultsHelper {

    private Double points;
    private Long quizId;
    private Long userId;

    public ResultsHelper() {
    }

    public ResultsHelper(Double points, Long quizId, Long userId) {
        this.points = points;
        this.quizId = quizId;
        this.userId = userId;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
