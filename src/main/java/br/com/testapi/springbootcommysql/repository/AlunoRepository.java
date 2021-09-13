package br.com.testapi.springbootcommysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.testapi.springbootcommysql.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
