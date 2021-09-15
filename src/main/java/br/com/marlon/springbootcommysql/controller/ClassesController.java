package br.com.marlon.springbootcommysql.controller;

import br.com.marlon.springbootcommysql.controller.dto.ClassesRq;

import br.com.marlon.springbootcommysql.controller.dto.ClassesRs;
import br.com.marlon.springbootcommysql.controller.dto.CourseRs;
import br.com.marlon.springbootcommysql.model.Classes;
import br.com.marlon.springbootcommysql.repository.ClassesRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("turma")
public class ClassesController {
    private final ClassesRepository classesRepository;


    public ClassesController(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @GetMapping("/")
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @PostMapping("/")
    public void postCourse(@RequestBody ClassesRq classes) {
        var c = new Classes();
        c.setName(classes.getName());
        classesRepository.save(c);
    }
}
