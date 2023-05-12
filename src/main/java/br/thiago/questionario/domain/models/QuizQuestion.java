package br.thiago.questionario.domain.models;

import br.thiago.questionario.modelos.InserirPerguntaRequestBody;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "QuizQuestion")
@Getter
@NoArgsConstructor
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "responseId")
    private List<QuizQuestion> responses;

    private String question;

    private String image;

    public QuizQuestion(InserirPerguntaRequestBody novaPergunta) {
        this.question = novaPergunta.getPergunta();
        this.image = novaPergunta.getImagem();
        this.responses = novaPergunta.getRespostas();
    }

}