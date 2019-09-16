package br.com.unicesumar.aep32.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Bimestre {
    Bim1("Primeiro Bimestre"), Bim2("Segundo Bimestre"), Bim3("Terceiro Bimestre"), Bim4("Quarto Bimestre");

    private String descricao;

}
