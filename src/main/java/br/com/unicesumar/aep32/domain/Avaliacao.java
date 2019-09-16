package br.com.unicesumar.aep32.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Avaliacao {

    @Id
    @Column(name = "id_avaliacao")
    private String id;
    private String materia;
    private String professor;
    @Enumerated(EnumType.STRING)
    private Bimestre bimestre;

    public Avaliacao(String materia, String professor, Bimestre bimestre) {
        this.id = UUID.randomUUID().toString();
        this.materia = materia;
        this.professor = professor;
        this.bimestre = bimestre;
    }
}
