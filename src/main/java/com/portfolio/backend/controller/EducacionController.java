package com.portfolio.backend.controller;
import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.service.EducacionService;
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
@RequestMapping("/api/educacion")
public class EducacionController {
    @Autowired
    private EducacionService educacionService;
    @Autowired
    private PersonaService personaService;


    @GetMapping("/listar")
        public ResponseEntity<List<Educacion>> listarEducacion() {
            return new ResponseEntity<>(educacionService.findALL(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Educacion> obtenerEducacion(@PathVariable Long id){
        return new ResponseEntity<>(educacionService.findById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion){
        return new ResponseEntity<>(educacionService.save(educacion), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Educacion> actualizarEducacion(@PathVariable Long id, @RequestBody Educacion educacion){
        Educacion educacionEncontrado = educacionService.findById(id);

        if (educacionEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            educacionEncontrado.setFechafinal(educacion.getFechafinal());
            educacionEncontrado.setFechainicio(educacion.getFechainicio());
            educacionEncontrado.setTitulo(educacion.getTitulo());
            educacionEncontrado.setDescripcion(educacion.getDescripcion());
            educacionEncontrado.setImagen_educacion(educacion.getImagen_educacion());
            return new ResponseEntity<>(educacionService.save(educacionEncontrado), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarEducacion(@PathVariable Long id){
        educacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
