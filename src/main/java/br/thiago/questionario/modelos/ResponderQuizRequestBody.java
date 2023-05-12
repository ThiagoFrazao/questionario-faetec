package br.thiago.questionario.modelos;

import br.thiago.questionario.domain.models.QuizQuestion;
import br.thiago.questionario.domain.models.QuizResponse;
import lombok.Data;

@Data
public class ResponderQuizRequestBody {

    private QuizQuestion pergunta;

    private QuizResponse resposta;

}