package br.thiago.questionario;

import br.thiago.questionario.domain.models.QuizQuestion;
import br.thiago.questionario.domain.models.UserResponse;
import br.thiago.questionario.domain.repository.QuizQuestionRepository;
import br.thiago.questionario.domain.repository.UserResponseRepository;
import br.thiago.questionario.exceptions.transactions.DbTransactionException;
import br.thiago.questionario.modelos.InserirPerguntaRequestBody;
import br.thiago.questionario.modelos.ResponderQuizRequestBody;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Slf4j
public class QuestionarioService {

    private final QuizQuestionRepository questionRepository;

    private final UserResponseRepository userResponseRepository;

    @Inject
    public QuestionarioService(QuizQuestionRepository questionRepository,
                               UserResponseRepository userResponseRepository) {
        this.questionRepository = questionRepository;
        this.userResponseRepository = userResponseRepository;
    }


    public List<QuizQuestion> recuperarQuestoes() {
        try {
            return this.questionRepository.findAll().list();
        } catch (Exception e) {
            log.error("Falha ao recuperar questoes", e);
            throw new DbTransactionException("Ocorreu um erro inesperado ao tentar recuperar as questoes.");
        }
    }

    @Transactional
    public void salvarResposta(ResponderQuizRequestBody usuarioResposta) {
        try {
            this.userResponseRepository.persist(new UserResponse(usuarioResposta));
        } catch (Exception e) {
            log.error("Falha ao salvar resposta do usuario", e);
            throw new DbTransactionException("Ocorreu um erro inesperado ao tentar salvar a resposta do questionario.");
        }
    }

    @Transactional
    public void salvarPergunta(InserirPerguntaRequestBody novaPergunta) {
        try {
            this.questionRepository.persist(new QuizQuestion(novaPergunta));
        } catch (Exception e) {
            log.error("Falha ao salvar pergunta", e);
            throw new DbTransactionException("Ocorreu um erro inesperado ao tentar salvar a pergunta.");
        }
    }

}