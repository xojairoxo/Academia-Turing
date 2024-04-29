package com.una.ac.cr.academiaturing_.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ausuario", schema = "academiaturing")
public class AusuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic
    @Column(name = "username")
    private String username;
    @OneToMany(mappedBy = "ausuarioByIdUsuario")
    private Collection<CursosusuariosEntity> cursosusuariosById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AusuarioEntity that = (AusuarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(contrasenia, that.contrasenia) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, contrasenia, username);
    }

    public Collection<CursosusuariosEntity> getCursosusuariosById() {
        return cursosusuariosById;
    }

    public void setCursosusuariosById(Collection<CursosusuariosEntity> cursosusuariosById) {
        this.cursosusuariosById = cursosusuariosById;
    }
}
