package br.com.marlon.springbootcommysql.controller;

import br.com.marlon.springbootcommysql.controller.dto.ClassesRq;

import br.com.marlon.springbootcommysql.model.Classes;
import br.com.marlon.springbootcommysql.repository.ClassesRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classes")
public class ClassesController {
    private final ClassesRepository classesRepository;
    private CourseController cc;

    public ClassesController(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @PostMapping("/")
    public void postClasses(@RequestBody ClassesRq classes) {
        var c = new Classes();
        c.setName(classes.getName());


    }
}
