package br.com.testapi.springbootcommysql.Controllers;

import br.com.testapi.springbootcommysql.Controllers.dto.AlunoRs;
import br.com.testapi.springbootcommysql.model.Aluno;
import br.com.testapi.springbootcommysql.repository.AlunoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluno")
public class AlunoController{

    private final AlunoRepository alunorepo;

    public AlunoController(AlunoRepository alunorepo) {
        this.alunorepo = alunorepo;
    }

    @GetMapping("/")
    public List<AlunoRs> findAll(){
        var aluno = alunorepo.findAll();
        return aluno.stream().map(AlunoRs::converter).collect(Collectors.toList());
    }

}
