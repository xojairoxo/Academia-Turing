package com.una.ac.cr.academiaturing_.presentation.usuario;


import com.una.ac.cr.academiaturing_.logic.AusuarioEntity;
import com.una.ac.cr.academiaturing_.service.CursoService;
import com.una.ac.cr.academiaturing_.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@org.springframework.stereotype.Controller("UsuarioController")

public class Controller {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    CursoService cursosService;
    @GetMapping("/presentation/usuario/show")
    public String showUsuarios() {
        return "index";
    }


    @PostMapping("/presentation/usuario/login")
    public String processLogin(Model model, String username, String password, HttpSession session) {
        Optional<AusuarioEntity>  optionalUsuario = usuarioService.usuarioFind(username, password);
        if (optionalUsuario.isPresent()) {
            session.setAttribute("usuario", optionalUsuario.get());
            model.addAttribute("cursos", cursosService.findAll());
            return "/presentation/usuario/View";
        } else {
            model.addAttribute("error", "Usuario o contraseña inválidos.");
            return "index";
        }
    }


    @GetMapping("/presentation/usuario/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }



}
