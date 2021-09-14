package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Course;

public class ClassesRq {
    private String name;
    private Course course;

    public ClassesRq(Course course) {
        this.course = course;
    }
}
