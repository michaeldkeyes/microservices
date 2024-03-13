package com.zoola.departmentservice.controller;

import com.zoola.departmentservice.client.EmployeeClient;
import com.zoola.departmentservice.model.Department;
import com.zoola.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;
    private final EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody final Department department) {
        log.info("Adding department: {}", department);

        return departmentService.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        log.info("Finding all departments");

        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable final long id) {
        log.info("Finding department by id: {}", id);

        return departmentService.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        log.info("Finding all departments with employees");

        List<Department> departments = departmentService.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));

        return departments;
    }
}
