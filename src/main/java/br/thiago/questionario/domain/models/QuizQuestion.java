package br.thiago.questionario.domain.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private List<QuizResponse> responses;

    private String question;

    private String image;

    public QuizQuestion(List<QuizResponse> responses, String question, String image) {
        this.responses = responses.stream().map(response -> new QuizResponse(response.getResponse(), response.getDescription())).toList();
        this.question = question;
        this.image = image;
    }

}