package br.com.marlon.springbootcommysql.controller;

import br.com.marlon.springbootcommysql.controller.dto.AlunoRq;
import br.com.marlon.springbootcommysql.controller.dto.AlunoRs;
import br.com.marlon.springbootcommysql.model.Aluno;
import br.com.marlon.springbootcommysql.repository.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;

    }

    @GetMapping("/")
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @PostMapping("/")
    public void postAluno(@RequestBody AlunoRq aluno) {
        var p = new Aluno();
        p.setNome(aluno.getNome());
        p.setMatricula(aluno.getMatricula());
        alunoRepository.save(p);
    }

    @PutMapping("/{id}")
    public void updateAluno(@PathVariable("") Long id, @RequestBody AlunoRq alunoRq) throws Exception {
        var p = alunoRepository.findById(id);

        if (p.isPresent()) {
            var pessoaSave = p.get();
            pessoaSave.setNome(alunoRq.getNome());
            pessoaSave.setMatricula(alunoRq.getMatricula());
            alunoRepository.save(pessoaSave);
        } else {
            throw new Exception("Aluno Não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<AlunoRs> findAlunoByName(@RequestParam("name") String name) {
        return this.alunoRepository.findByNomeContains(name)
                .stream()
                .map(AlunoRs::converter)
                .collect(Collectors.toList());
    }

    @DeleteMapping("Delete")
    public void DeleteAluno(@PathVariable("") Long id, @RequestBody AlunoRq alunoRq) throws Exception {
        var p = alunoRepository.findById(id);

        if (p.isPresent()) {
            var alunoSave = p.get();
            alunoRepository.delete(alunoSave);
        } else {
            throw new Exception("Aluno Não encontrada");
        }
    }

}
