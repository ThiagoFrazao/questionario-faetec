package br.thiago.questionario;

import br.thiago.questionario.domain.repository.QuizQuestionRepository;
import br.thiago.questionario.domain.repository.QuizResponseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class QuestionarioService {

    private final QuizQuestionRepository questionRepository;
    private final QuizResponseRepository responseRepository;

    @Inject
    public QuestionarioService(QuizQuestionRepository questionRepository, QuizResponseRepository responseRepository) {
        this.questionRepository = questionRepository;
        this.responseRepository = responseRepository;
    }





}
