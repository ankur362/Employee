package com.employee.EmployeeManagement.service;

import com.employee.EmployeeManagement.model.Employer;
import com.employee.EmployeeManagement.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public Employer getEmployerById(Long id) {
        return employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
    }

    public Employer addEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    public Employer updateEmployer(Long id, Employer employerDetails) {
        Employer employer = getEmployerById(id);
        employer.setName(employerDetails.getName());
        employer.setCompanyName(employerDetails.getCompanyName());
        employer.setEmail(employerDetails.getEmail());
        return employerRepository.save(employer);
    }

    public void deleteEmployer(Long id) {
        Employer employer = getEmployerById(id);
        employerRepository.delete(employer);
    }
}