package com.portfolio.backend.controller;
import com.portfolio.backend.model.Hard_soft_skills;
import com.portfolio.backend.service.Hard_soft_skillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/hard_soft_skills")
public class Hard_soft_skillsController {
    @Autowired
    private Hard_soft_skillsService hard_soft_skillsService;

    @GetMapping("/listar")
    public ResponseEntity<List<Hard_soft_skills>> listarHard_soft_skills() {
        return new ResponseEntity<>(hard_soft_skillsService.findALL(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Hard_soft_skills> crearHard_soft_skills(@RequestBody Hard_soft_skills hard_soft_skills){
        return new ResponseEntity<>(hard_soft_skillsService.save(hard_soft_skills), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Hard_soft_skills> actualizarHard_soft_skills(@PathVariable Long id, @RequestBody Hard_soft_skills hard_soft_skills){
        Hard_soft_skills hard_soft_skillsEncontrado = hard_soft_skillsService.findById(id);

        if (hard_soft_skillsEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            hard_soft_skillsEncontrado.setNombre(hard_soft_skills.getNombre());
            hard_soft_skillsEncontrado.setLink(hard_soft_skills.getLink());
            hard_soft_skillsEncontrado.setNivel(hard_soft_skills.getNivel());
            return new ResponseEntity<>(hard_soft_skillsService.save(hard_soft_skillsEncontrado), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarHard_soft_skills(@PathVariable Long id){
        hard_soft_skillsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
