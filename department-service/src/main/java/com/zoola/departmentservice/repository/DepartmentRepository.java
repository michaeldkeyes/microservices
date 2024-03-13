package com.zoola.departmentservice.repository;

import com.zoola.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private final List<Department> departments = new ArrayList<>();

    public Department addDepartment(final Department department) {
        departments.add(department);

        return department;
    }

    public Department findById(final long id) {
        return departments.stream().filter(department -> department.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Department> findAll() {
        return departments;
    }
}
