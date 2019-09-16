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
public class Nota {

    @Id
    @Column(name = "id_nota")
    private String id;
    private Double nota;

    public Nota(Double nota) {
        this.id = UUID.randomUUID().toString();
        if (nota >= 0 && nota <=10) {
            this.nota = nota;
        } else {
            throw new ValorDeNotaInvalidoException("Valor da nota deve ser entre 0 e 10");
        }
    }
}
