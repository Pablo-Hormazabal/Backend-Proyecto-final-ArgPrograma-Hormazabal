package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencia;

import java.util.List;

public interface IExperienciaService {
    public Experiencia save(Experiencia experiencia);
    public Experiencia findById(Long id);
    public List<Experiencia> findALL();
    public void delete(Long id);
}
