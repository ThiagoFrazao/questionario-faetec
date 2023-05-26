package br.thiago.questionario.domain.repository;

import br.thiago.questionario.domain.models.UserResponse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserResponseRepository implements PanacheRepository<UserResponse> {


    public long countResponsesForQuestion(Long questionId, Integer responseId) {
        return this.count("question.id = ?1 and response.id = ?2", questionId, responseId);
    }

}
