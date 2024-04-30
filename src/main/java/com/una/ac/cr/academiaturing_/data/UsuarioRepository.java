package com.una.ac.cr.academiaturing_.data;

import com.una.ac.cr.academiaturing_.logic.AusuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<AusuarioEntity, String> {
    Optional<AusuarioEntity> findByUsernameAndContrasenia(String usuario, String password);
}
