package br.thiago.questionario;

import br.thiago.questionario.domain.models.QuizQuestion;
import br.thiago.questionario.domain.models.QuizResponse;
import br.thiago.questionario.domain.models.UserResponse;
import br.thiago.questionario.domain.repository.QuizQuestionRepository;
import br.thiago.questionario.domain.repository.QuizResponseRepository;
import br.thiago.questionario.domain.repository.UserResponseRepository;
import br.thiago.questionario.exceptions.transactions.DbTransactionException;
import br.thiago.questionario.modelos.InserirPerguntaRequestBody;
import br.thiago.questionario.modelos.ResponderQuizRequestBody;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Slf4j
public class QuestionarioService {

    private final QuizQuestionRepository questionRepository;

    private final UserResponseRepository userResponseRepository;
    private final QuizResponseRepository responseRepository;

    @Inject
    public QuestionarioService(QuizQuestionRepository questionRepository,
                               UserResponseRepository userResponseRepository,
                               QuizResponseRepository responseRepository) {
        this.questionRepository = questionRepository;
        this.userResponseRepository = userResponseRepository;
        this.responseRepository = responseRepository;
    }


    public List<QuizQuestion> recuperarQuestoes() {
        try {
            return List.copyOf(this.questionRepository.findAll().list());
        } catch (Exception e) {
            log.error("Falha ao recuperar questoes", e);
            throw new DbTransactionException("Ocorreu um erro inesperado ao tentar recuperar as questoes.");
        }
    }

    @Transactional
    public void salvarResposta(List<ResponderQuizRequestBody> quizResponses) {
        try {
            List<UserResponse> responses = new ArrayList<>();
            quizResponses.forEach(response ->
                responses.add(new UserResponse(
                        this.questionRepository.findById(response.getPerguntaId()),
                        this.responseRepository.findById(response.getRespostaId())
                ))
            );
            this.userResponseRepository.persist(responses);
        } catch (Exception e) {
            log.error("Falha ao salvar resposta do usuario", e);
            throw new DbTransactionException("Ocorreu um erro inesperado ao tentar salvar a resposta do questionario.");
        }
    }

    @Transactional
    public void salvarPergunta(InserirPerguntaRequestBody novaPergunta) {
        try {
            List<QuizResponse> responses = this.responseRepository.findByIds(novaPergunta.getIdRespostas());
            QuizQuestion quizQuestion = new QuizQuestion(responses, novaPergunta.getPergunta(), novaPergunta.getImagem());
            this.questionRepository.persist(quizQuestion);
        } catch (Exception e) {
            log.error("Falha ao salvar pergunta", e);
            throw new DbTransactionException("Ocorreu um erro inesperado ao tentar salvar a pergunta.");
        }
    }

}