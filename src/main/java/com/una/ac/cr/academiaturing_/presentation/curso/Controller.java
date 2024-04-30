package com.una.ac.cr.academiaturing_.presentation.curso;

import com.una.ac.cr.academiaturing_.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller("cursoController")

public class Controller {
    @Autowired
    private CursoService cursoService;

    public Controller(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/presentation/curso/show")
    public String findAll(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "/presentation/usuario/View";
    }

}
