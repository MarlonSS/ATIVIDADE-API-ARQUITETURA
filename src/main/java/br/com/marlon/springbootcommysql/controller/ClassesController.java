package br.com.marlon.springbootcommysql.controller;

import br.com.marlon.springbootcommysql.controller.dto.ClassesRq;

import br.com.marlon.springbootcommysql.controller.dto.ClassesRs;
import br.com.marlon.springbootcommysql.controller.dto.CourseRq;
import br.com.marlon.springbootcommysql.controller.dto.CourseRs;
import br.com.marlon.springbootcommysql.model.Classes;
import br.com.marlon.springbootcommysql.repository.ClassesRepository;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.rmi.ServerException;
import java.util.List;
import java.util.stream.Collectors;

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
   public void postClasses(@RequestBody Classes classes) throws Exception {
       if (classes == null) {
           throw new Exception("Não há nada.");
       } else {
           classesRepository.save(classes);
       }
   }

    @PutMapping("/{id}")
    public void updateClasses(@PathVariable("") Long id, @RequestBody ClassesRq classesRq) throws Exception {
        var c = classesRepository.findById(id);

        if (c.isPresent()) {
            var courseSave = c.get();
            courseSave.setName(classesRq.getName());
        } else {
            throw new Exception("Turma Não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<ClassesRs> findCourseByName(@RequestParam("name") String name) {
        return this.classesRepository.findByNameContains(name)
                .stream()
                .map(ClassesRs::converter)
                .collect(Collectors.toList());
    }

    @DeleteMapping("Delete")
    public void DeleteAluno(@PathVariable("") Long id, @RequestBody ClassesRq classesRq) throws Exception {
        var p = classesRepository.findById(id);

        if (p.isPresent()) {
            var courseSave = p.get();
            classesRepository.delete(courseSave);
        } else {
            throw new Exception("turma Não encontrada");
        }
    }
}
