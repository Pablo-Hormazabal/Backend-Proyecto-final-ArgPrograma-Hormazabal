package com.portfolio.backend.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "proyectos")
@Table(name = "Proyectos")
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String link;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto(Long id, String titulo, String descripcion, String link) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link =descripcion;
    }

    public Proyecto() {
    }

    @ManyToOne
    @JoinColumn(name="Persona_id")
    private Persona persona;
}
