package br.thiago.questionario.modelos.graficos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DadosGraficoResponse {

    private String nome;

    private List<DadosPerguntas> dadosPerguntas;

}
