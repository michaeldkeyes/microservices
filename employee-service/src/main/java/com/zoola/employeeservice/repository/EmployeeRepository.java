package com.zoola.employeeservice.repository;

import com.zoola.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee add(final Employee employee) {
        employees.add(employee);

        return employee;
    }

    public  Employee findById(final Long id) {
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartmentId(final Long departmentId) {
        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .toList();
    }
}
