package com.una.ac.cr.academiaturing_.service;

import com.una.ac.cr.academiaturing_.data.CursoRepository;
import com.una.ac.cr.academiaturing_.logic.CursoEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void save(CursoEntity curso) {
        cursoRepository.save(curso);
    }

    public Iterable<CursoEntity> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<CursoEntity> findById(String codigo) {
        return cursoRepository.findByCodigo(codigo);
    }

    public void deleteById(String id) {
        cursoRepository.deleteById(id);
    }

    public void deleteAll() {
        cursoRepository.deleteAll();
    }

    public Optional<CursoEntity> findByCodigo(String codigo) {
        return cursoRepository.findByCodigo(codigo);
    }
}
