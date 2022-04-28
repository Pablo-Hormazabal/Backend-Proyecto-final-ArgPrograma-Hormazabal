package com.portfolio.backend.service;

import com.portfolio.backend.model.Hard_soft_skills;

import java.util.List;

public interface IHard_soft_skillsService {
    public Hard_soft_skills save(Hard_soft_skills hard_soft_skills);
    public Hard_soft_skills findById(Long id);
    public List<Hard_soft_skills> findALL();
    public void delete(Long id);
}
