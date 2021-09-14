package br.com.marlon.springbootcommysql.repository;

import br.com.marlon.springbootcommysql.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeContains(String name);
}
