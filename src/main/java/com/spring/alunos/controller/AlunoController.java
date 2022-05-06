package com.spring.alunos.controller;

import java.util.List;

import javax.validation.Valid;

import com.spring.alunos.model.entity.Aluno;
import com.spring.alunos.model.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/aluno/novo")
    public String formaluno(){
        return "formaluno";
    }
    @PostMapping("/aluno/novo")
    public String savealuno(@Valid Aluno aluno, BindingResult results, RedirectAttributes attributes){
        if(results.hasErrors()){
            attributes.addFlashAttribute("mensagem", "verifique se os campos form preenchidos");
            return "redirect:/aluno/novo";
        }else{
        as.saveAluno(aluno);
        return "redirect:/alunos";
        }
    }
}
