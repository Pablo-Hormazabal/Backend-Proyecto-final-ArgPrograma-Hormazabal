package com.portfolio.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="Educacion")
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String fechainicio;
    private String fechafinal;
    private String imagen_educacion;

    public String getImagen_educacion() {
        return imagen_educacion;
    }

    public void setImagen_educacion(String imagen_educacion) {
        this.imagen_educacion = imagen_educacion;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Educacion(Long id, String titulo, String fechainicio, String fechafinal, String descripcion, String imagen_educacion) {
        this.id = id;
        this.titulo = titulo;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.descripcion = descripcion;
        this.imagen_educacion = imagen_educacion;
    }


    public Educacion() {
    }

    @ManyToMany(mappedBy = "educacions")
    private Collection<Persona> personas;

}
