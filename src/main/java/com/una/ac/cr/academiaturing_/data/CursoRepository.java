package com.una.ac.cr.academiaturing_.data;

import com.una.ac.cr.academiaturing_.logic.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, String> {
}
