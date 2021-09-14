package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Aluno;

public class AlunoRs {

    private Long id;
    private String nome;
    private String matricula;

    public static AlunoRs converter(Aluno p) {
        var pessoa = new AlunoRs();
        pessoa.setId(p.getId());
        pessoa.setNome(p.getNome());
        pessoa.setSobrenome(p.getMatricula());
        return pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setSobrenome(String sobrenome) {
        this.matricula = matricula;
    }
}
