package br.com.marlon.springbootcommysql.controller;

import br.com.marlon.springbootcommysql.controller.dto.CourseRq;
import br.com.marlon.springbootcommysql.controller.dto.CourseRs;
import br.com.marlon.springbootcommysql.model.Course;
import br.com.marlon.springbootcommysql.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curso")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/")
    public List<CourseRs> findAll() {
        var courses = courseRepository.findAll();
        return courses
                .stream()
                .map(CourseRs::converter)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public void postCourse(@RequestBody CourseRq course) {
        var c = new Course();
        c.setName(course.getName());
        c.setTurn(course.getTurn());
        c.setWorkload(course.getWorkload());
        courseRepository.save(c);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("") Long id, @RequestBody CourseRq courseRq) throws Exception {
        var c = courseRepository.findById(id);

        if (c.isPresent()) {
            var courseSave = c.get();
            courseSave.setName(courseRq.getName());
          courseSave.setTurn(courseRq.getTurn());
          courseSave.setWorkload(courseRq.getWorkload());
            courseRepository.save(courseSave);
        } else {
            throw new Exception("Aluno Não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<CourseRs> findCourseByName(@RequestParam("name") String name) {
        return this.courseRepository.findByNameContains(name)
                .stream()
                .map(CourseRs::converter)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/")
    public void deleteClasses(@RequestParam("id") Long id) throws Exception {
        var p = courseRepository.findById(id);

        if (p.isPresent()) {
            courseRepository.deleteById(id);
        } else {
            throw new Exception("turma Não encontrada");
        }
    }

}
