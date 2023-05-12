package br.thiago.questionario.modelos;

import br.thiago.questionario.domain.models.QuizQuestion;
import lombok.Data;

import java.util.List;

@Data
public class InserirPerguntaRequestBody {

    private String pergunta;

    private List<QuizQuestion> respostas;

    private String imagem;

}