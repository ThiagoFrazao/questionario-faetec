package br.thiago.questionario.domain.repository;

import br.thiago.questionario.domain.models.QuizResponse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class QuizResponseRepository implements PanacheRepository<QuizResponse> {

    public List<QuizResponse> findByIds(List<Integer> ids) {
        return this.find("id in ?1", ids).list();
    }

}
