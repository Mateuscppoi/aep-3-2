package br.com.unicesumar.aep32.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConceitoDTO {

    @JsonProperty("nota")
    private Double nota;
    @JsonProperty("avaliacao")
    private AvaliacaoDTO avaliacao;
    @JsonProperty("aluno")
    private AlunoDTO aluno;
}
