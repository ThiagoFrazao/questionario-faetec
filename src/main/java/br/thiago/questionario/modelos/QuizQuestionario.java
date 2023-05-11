package br.thiago.questionario.modelos;

import lombok.Data;

import java.util.List;

@Data
public class QuizQuestionario {

    private String pergunta;

    private List<QuizRespostas> respostas;

    private String imagem;

}