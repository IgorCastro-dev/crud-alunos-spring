package com.spring.alunos.model.service;

import java.util.List;

import com.spring.alunos.model.entity.Aluno;

public interface AlunoService {
    List<Aluno> getAllAlunos();
    Aluno getAlunoById(Long id);
    Aluno saveAluno(Aluno aluno);
    Aluno updateAluno();
    void dropAluno();
}
