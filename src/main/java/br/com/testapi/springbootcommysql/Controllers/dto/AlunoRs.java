package br.com.testapi.springbootcommysql.Controllers.dto;

import br.com.testapi.springbootcommysql.model.Aluno;

public class AlunoRs {
    private long id;
    private String name;
    private String matricula;
    private int age;

    public static AlunoRs converter(Aluno a){
var alun = new AlunoRs();
alun.setId(a.getId());
alun.setName(a.getName());
alun.setMatricula(a.getMatricula());
        alun.setAge(a.getAge());
return alun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
