/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/persona")
public class controller {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listarPersona() {
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaEncontrado = personaService.findById(id);
        if (personaEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            personaEncontrado.setNombre(persona.getNombre());
            personaEncontrado.setApellido(persona.getApellido());
            personaEncontrado.setEmail(persona.getEmail());
            personaEncontrado.setCelular(persona.getCelular());
            personaEncontrado.setCiudad(persona.getCiudad());
            personaEncontrado.setFecha(persona.getFecha());
            personaEncontrado.setDescripcion(persona.getDescripcion());
            return new ResponseEntity<>(personaService.save(personaEncontrado), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarPersona(@PathVariable Long id){
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
