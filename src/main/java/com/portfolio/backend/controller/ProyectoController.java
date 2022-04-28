package com.portfolio.backend.controller;
import com.portfolio.backend.service.ProyectoService;
import com.portfolio.backend.model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;
    @GetMapping("/listar")
    public ResponseEntity<List<Proyecto>> listarProyecto() {
        return new ResponseEntity<>(proyectoService.findALL(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        return new ResponseEntity<>(proyectoService.save(proyecto), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
        Proyecto proyectoEncontrado = proyectoService.findById(id);

        if (proyectoEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            proyectoEncontrado.setTitulo(proyecto.getTitulo());
            proyectoEncontrado.setDescripcion(proyecto.getDescripcion());
            proyectoEncontrado.setLink(proyecto.getLink());
            return new ResponseEntity<>(proyectoService.save(proyectoEncontrado), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarProyecto(@PathVariable Long id){
        proyectoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
