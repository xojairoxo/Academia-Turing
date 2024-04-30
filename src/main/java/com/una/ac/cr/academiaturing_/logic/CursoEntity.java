package com.una.ac.cr.academiaturing_.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "curso", schema = "academiaturing")
public class CursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "cupo")
    private Integer cupo;
    @Basic
    @Column(name = "creditos")
    private Integer creditos;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoEntity that = (CursoEntity) o;
        return Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(cupo, that.cupo) && Objects.equals(creditos, that.creditos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, cupo, creditos);
    }
}
