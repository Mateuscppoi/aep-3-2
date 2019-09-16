package br.com.unicesumar.aep32.api;

import br.com.unicesumar.aep32.domain.*;
import br.com.unicesumar.aep32.dto.AlunoDTO;
import br.com.unicesumar.aep32.dto.AvaliacaoDTO;
import br.com.unicesumar.aep32.dto.ConceitoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/conceito")
public class ConceitoAPI {

    @Autowired
    private  ConceitoRepository conceitoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> get(@RequestBody ConceitoDTO dto) {
        checkArgument(nonNull(dto), "O conceito não pode ser nulo");
        checkArgument(nonNull(dto.getAluno()), "O aluno não pode ser nulo");
        checkArgument(nonNull(dto.getAvaliacao()), "A avaliação não pode ser nula");
        checkArgument(nonNull(dto.getNota()), "O conceito não pode ser nulo");
        Nota nota = new Nota(dto.getNota());
        Avaliacao avaliacao = new Avaliacao(dto.getAvaliacao().getMateria(), dto.getAvaliacao().getProfessor(), dto.getAvaliacao().getBimestre());
        Aluno aluno = new Aluno(dto.getAluno().getNome(), dto.getAluno().getCurso());
        Conceito conceito = new Conceito(nota, avaliacao, aluno);
        Conceito conceitoSalvo = conceitoRepository.save(conceito);
        return new ResponseEntity<>("Criado com sucesso, id: " + conceitoSalvo.getId(), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ConceitoDTO getConceito(@PathVariable("id") String id) {
        Optional<Conceito> conceitoOptional = conceitoRepository.findById(id);
        if (conceitoOptional.isPresent()){
            Conceito conceito = conceitoOptional.get();
            AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(conceito.getAvaliacao().getMateria(), conceito.getAvaliacao().getProfessor(), conceito.getAvaliacao().getBimestre());
            AlunoDTO aluno = new AlunoDTO(conceito.getAluno().getNome(), conceito.getAluno().getCurso());
            return new ConceitoDTO(conceito.getNota().getNota(), avaliacaoDTO, aluno);
        }
        throw new ConceitoNotFoundException("Não foi encontrado um conceito com o id: " + id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void updateConceito(@PathVariable("id") String id, @RequestBody ConceitoDTO conceitoDTO) {
        Optional<Conceito> conceitoOptional = conceitoRepository.findById(id);
        if (conceitoOptional.isPresent()){
            Conceito conceito = conceitoOptional.get();
            Nota nota = new Nota(conceitoDTO.getNota());
            Avaliacao avaliacao = new Avaliacao(conceitoDTO.getAvaliacao().getMateria(), conceitoDTO.getAvaliacao().getProfessor(), conceitoDTO.getAvaliacao().getBimestre());
            Aluno aluno = new Aluno(conceitoDTO.getAluno().getNome(), conceitoDTO.getAluno().getCurso());
            conceito.setAvaliacao(avaliacao);
            conceito.setAluno(aluno);
            conceito.setNota(nota);
            conceitoRepository.save(conceito);
        } else {
            throw new ConceitoNotFoundException("Não foi encontrado um conceito com o id: " + id);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteConceito(@PathVariable("id") String id) {
        Optional<Conceito> conceito = conceitoRepository.findById(id);
        if (conceito.isPresent()){
            conceitoRepository.delete(conceito.get());
        } else {
            throw new ConceitoNotFoundException("Não foi encontrado um conceito com o id: " + id);
        }
    }
}
