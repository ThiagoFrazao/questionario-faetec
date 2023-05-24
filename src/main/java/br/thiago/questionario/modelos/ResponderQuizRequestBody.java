package br.thiago.questionario.modelos;

import lombok.Data;

@Data
public class ResponderQuizRequestBody {

    private Long perguntaId;

    private Long respostaId;

}