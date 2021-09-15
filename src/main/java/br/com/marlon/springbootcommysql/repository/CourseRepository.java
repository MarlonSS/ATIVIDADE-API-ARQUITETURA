package br.com.marlon.springbootcommysql.repository;


import br.com.marlon.springbootcommysql.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameContains(String name);
    Optional<Course> findByName(String name);
}
