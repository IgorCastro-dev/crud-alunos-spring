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
import org.springframework.web.bind.annotation.PathVariable;
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
            attributes.addFlashAttribute("mensagem", "verifique se os campos foram preenchidos");
            return "redirect:/aluno/novo";
        }else{
        as.saveAluno(aluno);
        return "redirect:/alunos";
        }
    }
    @GetMapping("/aluno/edit/{id}")
    public String updatealuno(){
        return "updatealuno";
    }

    @PostMapping("/aluno/edit/{id}")
    public String atualizaaluno(@PathVariable Long id,Aluno aluno){
        Aluno alunoexistente = as.getAlunoById(id);
        alunoexistente.setFirstName(aluno.getFirstName());
        alunoexistente.setLastName(aluno.getLastName());
        alunoexistente.setEmail(aluno.getEmail());
        as.saveAluno(alunoexistente);
        return "redirect:/alunos";
    }
}
