package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRs {
    private Long id;
    private String name;
    private String turn;
    private String workload;

    public static CourseRs converter(Course course) {
        var c = new CourseRs();
        c.setId(course.getId());
        c.setName(course.getName());
        c.setTurn(course.getTurn());
        c.setWorkload(course.getWorkload());
        return c;
    }


}
