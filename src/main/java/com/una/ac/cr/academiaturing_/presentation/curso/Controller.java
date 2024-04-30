package com.una.ac.cr.academiaturing_.presentation.curso;

import com.una.ac.cr.academiaturing_.logic.AusuarioEntity;
import com.una.ac.cr.academiaturing_.logic.CursoEntity;
import com.una.ac.cr.academiaturing_.logic.CursosusuariosEntity;
import com.una.ac.cr.academiaturing_.service.CursoService;
import com.una.ac.cr.academiaturing_.service.MatriculaService;
import com.una.ac.cr.academiaturing_.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
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
    private MatriculaService matriculaService;

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
    public String agregaCurso(Model model, HttpSession session,
                              @RequestParam("id") String id,
                              @RequestParam("codigo") String codigo,
                              @RequestParam("horario") String horario,
                              @RequestParam("prioridad") String prioridad) {
        // Obtener el usuario y el curso
        Optional<AusuarioEntity> optionalUsuario = usuarioService.usuarioFindById(id);
        Optional<CursoEntity> optionalCurso = cursoService.findByCodigo(codigo);

        if (optionalUsuario.isPresent() && optionalCurso.isPresent()) {
            AusuarioEntity usuario = optionalUsuario.get();
            CursoEntity curso = optionalCurso.get();
            Boolean cursoYaMatriculado = matriculaService.ExistsByIdUsuarioAndIdCurso(usuario.getId(), curso.getCodigo());
            if (!cursoYaMatriculado) {
                // Crear una nueva instancia de CursosusuariosEntity
                CursosusuariosEntity cursosusuarios = new CursosusuariosEntity();
                cursosusuarios.setAusuarioByIdUsuario(usuario);
                cursosusuarios.setCursoByCodigoCurso(curso);
                cursosusuarios.setHorario(horario);
                cursosusuarios.setPrioridad(prioridad);
                matriculaService.save(cursosusuarios);
                return "redirect:/presentation/usuario/vistaUsuario";
            } else {
                // Agregar el mensaje de error al modelo
                session.setAttribute("errorMessage", "El curso ya está asignado al usuario.");
                return "redirect:/presentation/usuario/vistaUsuario";
            }
        } else {
            // Agregar el mensaje de error al modelo
            session.setAttribute("errorMessage", "Usuario o curso no encontrado.");
            return "redirect:/presentation/usuario/vistaUsuario";
        }
    }


}