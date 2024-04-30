package com.una.ac.cr.academiaturing_.service;

import com.una.ac.cr.academiaturing_.data.MatriculaRepository;
import com.una.ac.cr.academiaturing_.logic.CursosusuariosEntity;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    private MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public void save(CursosusuariosEntity matricula) {
        matriculaRepository.save(matricula);
    }

    public Iterable<CursosusuariosEntity> findAll() {
        return matriculaRepository.findAll();
    }

    public Iterable<CursosusuariosEntity> findByIdUsuario(String idUsuario) {
        return matriculaRepository.findByIdUsuario(idUsuario);
    }

    public void deleteById(String id) {
        matriculaRepository.deleteById(id);
    }

    public void deleteAll() {
        matriculaRepository.deleteAll();
    }

    public Boolean ExistsByIdUsuarioAndIdCurso(String id, String codigo) {
        return matriculaRepository.existsByIdUsuarioAndCodigoCurso(id, codigo);
    }
}
