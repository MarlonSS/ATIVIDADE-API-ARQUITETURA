package br.com.marlon.springbootcommysql.model;
/*import javax.persistence.*;*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Classes")
public class Classes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Transient
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_course")
    private Course course;


    public Classes(Course course) {
        this.course = course;
    }
}
