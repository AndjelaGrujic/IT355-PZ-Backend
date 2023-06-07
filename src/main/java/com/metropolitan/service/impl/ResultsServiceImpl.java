package com.metropolitan.service.impl;

import com.metropolitan.model.Results;
import com.metropolitan.model.dto.ResultsHelper;
import com.metropolitan.model.User;
import com.metropolitan.model.quiz.Quiz;
import com.metropolitan.repository.QuizRepository;
import com.metropolitan.repository.ResultsRepository;
import com.metropolitan.repository.UserRepository;
import com.metropolitan.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsServiceImpl implements ResultsService {

    @Autowired
    private ResultsRepository repository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Results createResults(ResultsHelper results) {
        Quiz q = quizRepository.findById(results.getQuizId()).get();
        User u = userRepository.findById(results.getUserId()).get();
        Results res = new Results(u,q,results.getPoints());
        return repository.save(res);
    }

    @Override
    public List<Results> getAllResults() {
        return repository.findAll();
    }
}
