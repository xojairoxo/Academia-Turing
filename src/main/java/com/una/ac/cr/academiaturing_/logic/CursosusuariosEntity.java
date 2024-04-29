package com.una.ac.cr.academiaturing_.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cursosusuarios", schema = "academiaturing")
public class CursosusuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registro")
    private int idRegistro;
    @Basic
    @Column(name = "id_usuario",insertable=false, updatable=false)
    private String idUsuario;
    @Basic
    @Column(name = "codigo_curso",insertable=false, updatable=false)
    private String codigoCurso;
    @Basic
    @Column(name = "horario")
    private String horario;
    @Basic
    @Column(name = "prioridad")
    private String prioridad;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private AusuarioEntity ausuarioByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo")
    private CursoEntity cursoByCodigoCurso;

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosusuariosEntity that = (CursosusuariosEntity) o;
        return idRegistro == that.idRegistro && Objects.equals(idUsuario, that.idUsuario) && Objects.equals(codigoCurso, that.codigoCurso) && Objects.equals(horario, that.horario) && Objects.equals(prioridad, that.prioridad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegistro, idUsuario, codigoCurso, horario, prioridad);
    }

    public AusuarioEntity getAusuarioByIdUsuario() {
        return ausuarioByIdUsuario;
    }

    public void setAusuarioByIdUsuario(AusuarioEntity ausuarioByIdUsuario) {
        this.ausuarioByIdUsuario = ausuarioByIdUsuario;
    }

    public CursoEntity getCursoByCodigoCurso() {
        return cursoByCodigoCurso;
    }

    public void setCursoByCodigoCurso(CursoEntity cursoByCodigoCurso) {
        this.cursoByCodigoCurso = cursoByCodigoCurso;
    }
}
