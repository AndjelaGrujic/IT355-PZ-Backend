package com.metropolitan.test.question;


import com.metropolitan.model.quiz.Question;
import com.metropolitan.model.quiz.Quiz;
import com.metropolitan.repository.QuestionRepository;
import com.metropolitan.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceImplTest {

    Question question;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {

        question = new Question();

        question.setQuesId(1L);
        question.setContent("React is a framework of:");
        question.setImage("");
        question.setOption1("JS");
        question.setOption2("Java");
        question.setOption3("Python");
        question.setOption4("Go");
        question.setAnswer("JS");
    }

    @Test
    void addQuestionTest() {
        when(questionRepository.save(question)).thenReturn(question);
        Assertions.assertEquals(question, questionService.addQuestion(question));
    }

    @Test
    void updateQuestionTest() {
        when(questionRepository.save(question)).thenReturn(question);
        Assertions.assertEquals(question, questionService.updateQuestion(question));
    }

    @Test
    void getQuestionsTest() {
        List<Question> questions = Arrays.asList(question);
        when(questionRepository.findAll()).thenReturn(questions);
        Set<Question> expectedQuestions = questionService.getQuestions();
        Assertions.assertTrue(expectedQuestions.contains(question));

    }

    @Test
    void getQuestionTest() {
        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));
        Assertions.assertEquals(question, questionService.getQuestion(1L));
    }

    @Test
    void getQuestionsOfQuizTest() {

        Quiz quiz = new Quiz();
        Set<Question> questions = new HashSet<>();
        questions.add(question);
        when(questionRepository.findByQuiz(quiz)).thenReturn(questions);
        Set<Question> expectedQuestions = questionService.getQuestionsOfQuiz(quiz);
        Assertions.assertTrue(expectedQuestions.contains(question));

    }

    @Test
    void deleteQuestionTest() {
        doNothing().when(questionRepository).deleteById(1L);
        Assertions.assertDoesNotThrow(() -> questionService.deleteQuestion(1L));
    }
}
