package com.portfolio.backend.controller;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.service.ExperienciaService;
import com.portfolio.backend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {
    @Autowired
    private ExperienciaService experienciaService;
    @Autowired
    private PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Experiencia>> listarExperiencia() {
        return new ResponseEntity<>(experienciaService.findALL(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia experiencia){
        return new ResponseEntity<>(experienciaService.save(experiencia), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Experiencia> actualizarExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia){
        Experiencia experienciaEncontrado = experienciaService.findById(id);

        if (experienciaEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            experienciaEncontrado.setNombre(experiencia.getNombre());
            experienciaEncontrado.setDescripcion(experiencia.getDescripcion());
            return new ResponseEntity<>(experienciaService.save(experienciaEncontrado), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarEducacion(@PathVariable Long id){
        experienciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
