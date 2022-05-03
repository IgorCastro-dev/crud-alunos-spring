package com.spring.alunos;

import com.spring.alunos.model.repository.AlunoRepository;

import java.util.List;

import com.spring.alunos.model.entity.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlunosApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AlunosApplication.class, args);
	}

	@Autowired
	AlunoRepository ar;

	@Override
	public void run(String... args) throws Exception {
		
	}

}
