package br.thiago.questionario.domain.repository;

import br.thiago.questionario.domain.models.QuizResponse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuizResponseRepository implements PanacheRepository<QuizResponse> {
}
