package com.spring.alunos.model.repository;

import com.spring.alunos.model.entity.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{
    
}
