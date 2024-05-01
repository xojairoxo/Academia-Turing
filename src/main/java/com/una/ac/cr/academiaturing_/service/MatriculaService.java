package com.una.ac.cr.academiaturing_.service;

import com.una.ac.cr.academiaturing_.data.MatriculaRepository;
import com.una.ac.cr.academiaturing_.logic.CursoEntity;
import com.una.ac.cr.academiaturing_.logic.CursosusuariosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

    public void deleteByIdUsuarioAndCodigoCurso(String id, String codigo) {
        matriculaRepository.deleteByIdUsuarioAndCodigoCurso(id, codigo);
    }

    public int calcularCreditosMatriculados(String idUsuario) {
        Iterable<CursosusuariosEntity> cursosMatriculados = matriculaRepository.findByIdUsuario(idUsuario);
        // Calcular la suma de créditos de los cursos matriculados
        int creditosMatriculados = 0;
        for (CursosusuariosEntity cursoUsuario : cursosMatriculados) {
            CursoEntity curso = cursoUsuario.getCursoByCodigoCurso();
            if (curso != null) {
                creditosMatriculados += curso.getCreditos();
            }
        }
        return creditosMatriculados;
    }
    public boolean puedeMatricular(String idUsuario, int creditosNuevoCurso) {
        int creditosMatriculados = calcularCreditosMatriculados(idUsuario);
        return (creditosMatriculados + creditosNuevoCurso) <= 12;
    }



}
