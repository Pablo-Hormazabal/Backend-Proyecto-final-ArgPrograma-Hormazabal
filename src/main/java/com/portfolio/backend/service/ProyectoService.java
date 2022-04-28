package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto findById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> findALL() {
        return proyectoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        proyectoRepository.deleteById(id);

    }
}
