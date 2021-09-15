package br.com.marlon.springbootcommysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Aluno")
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="matricula")
    private String matricula;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_turma")
    private Classes classes;

}
