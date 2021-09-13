package br.com.testapi.springbootcommysql.model;

import javax.persistence.*;

@Entity
@Table(name="Aluno")
public class Aluno{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="cd_aluno")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="matricula")
    private String matricula;
    @Column(name="age")
    private int age;

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
