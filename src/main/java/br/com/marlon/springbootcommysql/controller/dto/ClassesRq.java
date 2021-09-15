package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassesRq {
    private String name;
    private Long course;
}
