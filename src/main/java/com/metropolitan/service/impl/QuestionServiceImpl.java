package com.metropolitan.service.impl;


import com.metropolitan.model.quiz.Question;
import com.metropolitan.model.quiz.Quiz;
import com.metropolitan.repository.QuestionRepository;
import com.metropolitan.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long quesid) {
        return questionRepository.findById(quesid).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesid) {
        questionRepository.deleteById(quesid);
    }
}
