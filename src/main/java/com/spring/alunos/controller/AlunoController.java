package com.spring.alunos.controller;

import java.util.List;

import com.spring.alunos.model.entity.Aluno;
import com.spring.alunos.model.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {

    @Autowired
    AlunoService as;
    
    @GetMapping("/alunos")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("alunos");
        List<Aluno> alunos = as.getAllAlunos();
        mv.addObject("alunos", alunos);
        return mv;
    }
}
