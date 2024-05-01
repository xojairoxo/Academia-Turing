package com.una.ac.cr.academiaturing_.data;

import com.una.ac.cr.academiaturing_.logic.CursoEntity;
import com.una.ac.cr.academiaturing_.logic.CursosusuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<CursosusuariosEntity, String> {
    Iterable<CursosusuariosEntity> findByIdUsuario(String idUsuario);
    Boolean existsByIdUsuarioAndCodigoCurso (String idUsuario, String codigoCurso);
    void deleteByIdUsuarioAndCodigoCurso (String idUsuario, String codigoCurso);


}
