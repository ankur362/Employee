package com.employee.EmployeeManagement.repository;
import com.employee.EmployeeManagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface ProjectRepository extends JpaRepository<Project, Long>{
}
