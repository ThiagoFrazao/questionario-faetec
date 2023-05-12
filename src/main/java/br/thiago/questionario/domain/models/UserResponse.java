package br.thiago.questionario.domain.models;

import br.thiago.questionario.modelos.ResponderQuizRequestBody;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userresponse")
@NoArgsConstructor
public class UserResponse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "response_id")
    private QuizResponse response;

    @JoinColumn(name = "question_id")
    @OneToOne
    private QuizQuestion question;

    public UserResponse(ResponderQuizRequestBody usuarioResposta) {
        this.question = usuarioResposta.getPergunta();
        this.response = usuarioResposta.getResposta();
    }

}
