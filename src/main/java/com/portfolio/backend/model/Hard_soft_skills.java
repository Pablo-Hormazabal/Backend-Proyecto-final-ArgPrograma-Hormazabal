package com.portfolio.backend.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Hard_soft_skills")
public class Hard_soft_skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name="link", length=1000)
    private String link;
    private String nivel;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLink() {
        return link;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Hard_soft_skills(Long id, String nombre, String link, String nivel ) {
        this.id = id;
        this.nombre = nombre;
        this.link = link;
        this.nivel= nivel;
    }

    public Hard_soft_skills() {
    }

    @ManyToMany(mappedBy = "hard_soft_skills")
    private Collection<Persona> personas;
}
