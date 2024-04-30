package com.una.ac.cr.academiaturing_.data;

import com.una.ac.cr.academiaturing_.logic.CursosusuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<CursosusuariosEntity, String> {

}
