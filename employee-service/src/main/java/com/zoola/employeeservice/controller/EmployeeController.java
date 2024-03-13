package com.zoola.employeeservice.controller;

import com.zoola.employeeservice.model.Employee;
import com.zoola.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee add(@RequestBody final Employee employee) {
        log.info("Employee add: {}", employee);

        return employeeService.add(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable final Long id) {
        log.info("Employee find: id={}", id);

        return employeeService.findById(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        log.info("Employee find");

        return employeeService.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable final Long departmentId) {
        log.info("Employee find: departmentId={}", departmentId);

        return employeeService.findByDepartmentId(departmentId);
    }
}
