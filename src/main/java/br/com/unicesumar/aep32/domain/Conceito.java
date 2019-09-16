package br.com.unicesumar.aep32.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Conceito {

    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nota")
    private Nota nota;
    @JoinColumn(name = "id_avaliacao")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Avaliacao avaliacao;
    @JoinColumn(name = "id_aluno")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Aluno aluno;

    public Conceito(Nota nota, Avaliacao avaliacao, Aluno aluno) {
        this.id = UUID.randomUUID().toString();
        this.nota = nota;
        this.avaliacao = avaliacao;
        this.aluno = aluno;
    }
}
