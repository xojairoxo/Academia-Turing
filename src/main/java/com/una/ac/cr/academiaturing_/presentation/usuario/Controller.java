package com.una.ac.cr.academiaturing_.presentation.usuario;


import com.una.ac.cr.academiaturing_.logic.AusuarioEntity;
import com.una.ac.cr.academiaturing_.logic.CursoEntity;
import com.una.ac.cr.academiaturing_.logic.CursosusuariosEntity;
import com.una.ac.cr.academiaturing_.service.CursoService;
import com.una.ac.cr.academiaturing_.service.MatriculaService;
import com.una.ac.cr.academiaturing_.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@org.springframework.stereotype.Controller("UsuarioController")

public class Controller {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    CursoService cursosService;
    @Autowired
    MatriculaService matriculaService;
    @GetMapping("/presentation/usuario/show")
    public String showUsuarios() {
        return "index";
    }


    @PostMapping("/presentation/usuario/login")
    public String processLogin(Model model, String username, String password, HttpSession session) {
        Optional<AusuarioEntity> optionalUsuario = usuarioService.usuarioFind(username, password);
        if (optionalUsuario.isPresent()) {
            session.setAttribute("usuario", optionalUsuario.get());
            session.setAttribute("idUsuario", optionalUsuario.get().getId()); // Set the idUsuario attribute
            return "redirect:/presentation/usuario/vistaUsuario";
        } else {
            model.addAttribute("error", "Usuario o contraseña inválidos.");
            return "index";
        }
    }

    @GetMapping("/presentation/usuario/cursoSelect")
    public String saveCurso(Model model, @RequestParam("id") String id, @RequestParam("codigo") String codigo, HttpSession session) {
        Optional<AusuarioEntity> usuario = usuarioService.usuarioFindById(id);
        Optional<CursoEntity> curso = cursosService.findByCodigo(codigo);
      if(curso.isPresent()) {
          session.setAttribute("curso",curso.get());
          return "redirect:/presentation/usuario/vistaUsuario";
      }else {
          model.addAttribute("error", "Curso no encontrado.");
          return "index";
      }

    }
    @GetMapping("/presentation/usuario/vistaUsuario")
    public String cursosUsuario(Model model, HttpSession session) {
        String idUsuario = (String) session.getAttribute("idUsuario");
        Iterable<CursosusuariosEntity> cursosMatricula = matriculaService.findByIdUsuario(idUsuario);
        model.addAttribute("curso", session.getAttribute("curso"));
        model.addAttribute("cursos", cursosService.findAll());
        model.addAttribute("cursosMatricula", cursosMatricula);
         //Obtener y eliminar el mensaje de error de la sesión
        String errorMessage = (String) session.getAttribute("errorMessage");
        session.removeAttribute("errorMessage");
        model.addAttribute("errorMessage",errorMessage);
        return "/presentation/usuario/View";
    }


    @GetMapping("/presentation/usuario/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }



}
