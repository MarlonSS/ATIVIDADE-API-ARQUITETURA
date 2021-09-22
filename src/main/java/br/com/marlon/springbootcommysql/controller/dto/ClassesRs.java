package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Classes;
import br.com.marlon.springbootcommysql.model.Course;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ClassesRs {

    private Long id;
    private String name;
    private Course course;

    public static ClassesRs converter(Classes classes) {
        var c = new ClassesRs();
        c.setId(classes.getId());
        c.setName(classes.getName());
        c.setCourse(classes.getCourse());
        return c;
    }
}
