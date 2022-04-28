package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;

import java.util.List;

public interface IEducacionService {

    public Educacion save(Educacion educacion);
    public Educacion findById(Long id);
    public List<Educacion> findALL();
    public void delete(Long id);

}
