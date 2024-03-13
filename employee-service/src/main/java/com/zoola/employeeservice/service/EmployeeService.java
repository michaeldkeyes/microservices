package com.zoola.employeeservice.service;

import com.zoola.employeeservice.model.Employee;
import com.zoola.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee add(final Employee employee) {
        return employeeRepository.add(employee);
    }

    public Employee findById(final Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByDepartmentId(final Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
