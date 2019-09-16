package br.com.unicesumar.aep32.dto;

import br.com.unicesumar.aep32.domain.Bimestre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvaliacaoDTO {


    private String materia;
    private String professor;
    @Enumerated(EnumType.STRING)
    private Bimestre bimestre;
}
