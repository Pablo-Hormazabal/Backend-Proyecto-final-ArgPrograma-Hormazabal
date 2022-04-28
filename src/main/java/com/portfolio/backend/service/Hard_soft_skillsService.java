package com.portfolio.backend.service;

import com.portfolio.backend.model.Hard_soft_skills;
import com.portfolio.backend.repository.Hard_soft_skillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hard_soft_skillsService implements IHard_soft_skillsService {
    @Autowired
    private Hard_soft_skillsRepository hard_soft_skillsRepository;

    @Override
    public Hard_soft_skills save(Hard_soft_skills hard_soft_skills) {
        return hard_soft_skillsRepository.save(hard_soft_skills);
    }

    @Override
    public Hard_soft_skills findById(Long id) {
        return hard_soft_skillsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Hard_soft_skills> findALL() {
        return hard_soft_skillsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        hard_soft_skillsRepository.deleteById(id);

    }
}
