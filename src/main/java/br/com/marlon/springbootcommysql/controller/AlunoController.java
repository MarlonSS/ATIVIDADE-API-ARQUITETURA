package br.com.marlon.springbootcommysql.controller;

import br.com.marlon.springbootcommysql.controller.dto.AlunoRq;
import br.com.marlon.springbootcommysql.controller.dto.AlunoRs;
import br.com.marlon.springbootcommysql.model.Aluno;
import br.com.marlon.springbootcommysql.model.Classes;
import br.com.marlon.springbootcommysql.repository.AlunoRepository;
import com.sun.jdi.connect.LaunchingConnector;
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
    public void postClasses(@RequestBody Aluno aluno) throws Exception {
        if (aluno == null) {
            throw new Exception("Não há nada.");
        } else {
            alunoRepository.save(aluno);
        }
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

    @DeleteMapping("/")
    public void deleteAluno(@RequestParam("id") Long id) throws Exception {
        var p = alunoRepository.findById(id);

        if (p.isPresent()) {
            alunoRepository.deleteById(id);
        } else {
            throw new Exception("turma Não encontrada");
        }
    }

}
