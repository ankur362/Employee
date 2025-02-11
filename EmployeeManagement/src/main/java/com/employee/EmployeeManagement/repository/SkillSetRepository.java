package com.employee.EmployeeManagement.repository;
import com.employee.EmployeeManagement.model.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface SkillSetRepository extends JpaRepository<SkillSet, Long>{
}
