package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Aluno;
import br.com.marlon.springbootcommysql.model.Classes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoRs {

    private Long id;
    private String nome;
    private String matricula;
    private Classes classes;

    public static AlunoRs converter(Aluno p) {
        var pessoa = new AlunoRs();
        pessoa.setId(p.getId());
        pessoa.setNome(p.getNome());
        pessoa.setMatricula(p.getMatricula());
        pessoa.setClasses(p.getClasses());
        return pessoa;
    }

}
