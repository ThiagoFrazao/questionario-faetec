package br.thiago.questionario.modelos;

import lombok.Data;

import java.util.List;

@Data
public class InserirPerguntaRequestBody {

    private String pergunta;

    private List<Integer> idRespostas;

    private String imagem;

}