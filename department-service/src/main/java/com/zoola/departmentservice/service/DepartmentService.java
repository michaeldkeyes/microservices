package com.zoola.departmentservice.service;

import com.zoola.departmentservice.model.Department;
import com.zoola.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department addDepartment(final Department department) {
        return departmentRepository.addDepartment(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(final long id) {
        return departmentRepository.findById(id);
    }
}
