package com.spring.alunos.model.service.impl;

import java.util.List;

import com.spring.alunos.model.entity.Aluno;
import com.spring.alunos.model.repository.AlunoRepository;
import com.spring.alunos.model.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    public AlunoRepository ar;

    @Override
    public List<Aluno> getAllAlunos() {
        return ar.findAll();
    }

    @Override
    public Aluno getAlunoById(Long id) {
        return ar.findById(id).get();
    }

    @Override
    public Aluno saveAluno(Aluno aluno) {
        return ar.save(aluno);
    }

    @Override
    public Aluno updateAluno() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void dropAluno() {
        // TODO Auto-generated method stub
        
    }
    
}
