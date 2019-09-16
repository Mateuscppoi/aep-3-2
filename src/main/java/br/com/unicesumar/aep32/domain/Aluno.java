package br.com.unicesumar.aep32.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Aluno {

    @Id
    @Column(name = "id_aluno")
    private String id;
    private String nome;
    private String curso;

    public Aluno(String nome, String curso) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.curso = curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
