package com.una.ac.cr.academiaturing_.service;


import com.una.ac.cr.academiaturing_.data.UsuarioRepository;
import com.una.ac.cr.academiaturing_.logic.AusuarioEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void save(AusuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }

    public Optional<AusuarioEntity> usuarioFind(String usuario, String password) {
        return usuarioRepository.findByUsernameAndContrasenia(usuario, password);
    }



}
