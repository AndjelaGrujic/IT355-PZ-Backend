package com.metropolitan.repository;


import com.metropolitan.model.quiz.Question;
import com.metropolitan.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
