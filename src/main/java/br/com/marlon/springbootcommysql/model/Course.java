package br.com.marlon.springbootcommysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="turn")
    private String turn;

    @Column(name="workload")
    private String workload;

   @OneToMany(fetch = FetchType.LAZY, targetEntity = Classes.class, cascade = CascadeType.ALL)
    private List<Classes> classes;
}
