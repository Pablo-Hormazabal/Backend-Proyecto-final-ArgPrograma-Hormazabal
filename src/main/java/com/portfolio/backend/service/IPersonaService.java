/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;
import java.util.List;


public interface IPersonaService {
    public Persona save(Persona persona);
    public Persona findById(Long id);
    public List<Persona>findAll();
    public void delete(Long id);


}
