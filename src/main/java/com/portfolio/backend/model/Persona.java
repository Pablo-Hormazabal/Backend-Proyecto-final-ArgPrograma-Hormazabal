
package com.portfolio.backend.model;
import javax.persistence.*;

import java.util.Collection;
import java.util.List;
@Entity
@Table(name="Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Apellido")
    private String apellido;
    @Column(name="Email")
    private String email;
    @Column(name="Celular")
    private String celular;
    @Column(name="Ciudad")
    private String ciudad;
    @Column(name="Fecha_Nacimiento")
    private String fecha;
    @Column(name="Descripcion")
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona(){
    }
    
    public Persona(Long id, String nombre, String apellido, String email, String celular, String ciudad, String fecha, String descripcion){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.celular=celular;
        this.ciudad=ciudad;
        this.fecha=fecha;
        this.descripcion=descripcion;
    }

    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;

    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencias;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name ="persona_educacion",
            joinColumns = @JoinColumn(name="persona_id"),
            inverseJoinColumns = @JoinColumn(name = "eduacion_id")

    )
    private Collection<Educacion> educacions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name ="persona_hardsoftskill",
            joinColumns = @JoinColumn(name="persona_id"),
            inverseJoinColumns = @JoinColumn(name = "hardsoftskill_id")

    )
    private Collection<Hard_soft_skills> hard_soft_skills;
}
