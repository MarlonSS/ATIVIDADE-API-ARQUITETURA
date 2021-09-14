package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Classes;
import br.com.marlon.springbootcommysql.model.Course;

public class ClassesRs {
    private Long id;
    private String name;
    private Course course;

    public ClassesRs(Course course) {
        this.course = course;
    }

    public static ClassesRs converter(Classes c,Course course) {
        var classes = new ClassesRs(course);
        classes.setId(c.getId());
        classes.setName(c.getName());
        return classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }
}
