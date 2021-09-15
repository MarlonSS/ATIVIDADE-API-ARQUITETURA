package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Classes;
import br.com.marlon.springbootcommysql.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassesRs {
    private Long id;
    private String name;
    private Course idcourse;


    public static ClassesRs converter(Classes c) {
        var classes = new ClassesRs();
        classes.setId(c.getId());
        classes.setName(c.getName());
        classes.setIdcourse(c.getCourse());
        return classes;
    }

}
