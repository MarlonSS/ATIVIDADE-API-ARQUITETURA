package br.com.marlon.springbootcommysql.repository;

import br.com.marlon.springbootcommysql.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes,Long>{
    List<Classes> findByNameContains(String name);
}
