package com.employee.EmployeeManagement.controller;

import com.employee.EmployeeManagement.model.SkillSet;
import com.employee.EmployeeManagement.service.SkillSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skillsets")
@RequiredArgsConstructor
public class SkillSetController {
    private final SkillSetService skillSetService;

    @GetMapping
    public ResponseEntity<List<SkillSet>> getAllSkillSets() {
        return ResponseEntity.ok(skillSetService.getAllSkillSets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillSet> getSkillSetById(@PathVariable Long id) {
        Optional<SkillSet> skillSet = skillSetService.getSkillSetById(id);
        return skillSet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SkillSet> addSkillSet(@RequestBody SkillSet skillSet) {
        return ResponseEntity.ok(skillSetService.addSkillSet(skillSet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillSet> updateSkillSet(@PathVariable Long id, @RequestBody SkillSet skillSetDetails) {
        return ResponseEntity.ok(skillSetService.updateSkillSet(id, skillSetDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkillSet(@PathVariable Long id) {
        skillSetService.deleteSkillSet(id);
        return ResponseEntity.noContent().build();
    }
}