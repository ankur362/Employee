package com.employee.EmployeeManagement.service;

import com.employee.EmployeeManagement.model.SkillSet;
import com.employee.EmployeeManagement.repository.SkillSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillSetService {
    private final SkillSetRepository skillSetRepository;

    public List<SkillSet> getAllSkillSets() {
        return skillSetRepository.findAll();
    }

    public Optional<SkillSet> getSkillSetById(Long id) {
        return skillSetRepository.findById(id);
    }

    public SkillSet addSkillSet(SkillSet skillSet) {
        return skillSetRepository.save(skillSet);
    }

    public SkillSet updateSkillSet(Long id, SkillSet skillSetDetails) {
        return skillSetRepository.findById(id).map(skillSet -> {
            skillSet.setName(skillSetDetails.getName());
            return skillSetRepository.save(skillSet);
        }).orElseThrow(() -> new RuntimeException("SkillSet not found"));
    }

    public void deleteSkillSet(Long id) {
        if (skillSetRepository.existsById(id)) {
            skillSetRepository.deleteById(id);
        } else {
            throw new RuntimeException("SkillSet not found");
        }
    }
}
