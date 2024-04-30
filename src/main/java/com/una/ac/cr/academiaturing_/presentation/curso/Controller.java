package com.una.ac.cr.academiaturing_.presentation.curso;

import com.una.ac.cr.academiaturing_.logic.AusuarioEntity;
import com.una.ac.cr.academiaturing_.logic.CursoEntity;
import com.una.ac.cr.academiaturing_.service.CursoService;
import com.una.ac.cr.academiaturing_.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@org.springframework.stereotype.Controller("cursoController")

public class Controller {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    public Controller(CursoService cursoService) {
        this.cursoService = cursoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/presentation/curso/show")
    public String findAll(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "/presentation/usuario/View";
    }

    @PostMapping("/presentation/usuario/agregaCurso")
    public String agregaCurso(Model model, @RequestParam("id") String id,
                              @RequestParam("codigo") String codigo,
                              @RequestParam("horario") String horario,
                              @RequestParam("prioridad") String prioridad) {
        Optional<AusuarioEntity> usuario = usuarioService.usuarioFindById(id);
        CursoEntity curso = cursoService.findByCodigo(codigo);
//        curso.setHorario(horario);
//        curso.setPrioridad(prioridad);
//        usuario.getCursos().add(curso);
//        usuarioService.save(usuario);
//        cursosService.delete(codigo);
        model.addAttribute("cursos", cursoService.findAll());
        return "/presentation/usuario/View";
    }

}
