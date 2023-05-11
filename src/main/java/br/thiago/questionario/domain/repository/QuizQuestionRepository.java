package br.thiago.questionario.domain.repository;

import br.thiago.questionario.domain.models.QuizQuestion;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuizQuestionRepository implements PanacheRepository<QuizQuestion> {
}
