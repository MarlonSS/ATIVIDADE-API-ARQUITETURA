package br.com.marlon.springbootcommysql.controller.dto;

import br.com.marlon.springbootcommysql.model.Course;


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

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }
}
