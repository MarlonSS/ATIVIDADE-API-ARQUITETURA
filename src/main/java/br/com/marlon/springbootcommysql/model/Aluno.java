package br.com.marlon.springbootcommysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name="id_turma", referencedColumnName = "id")
    private Classes classes;

}
