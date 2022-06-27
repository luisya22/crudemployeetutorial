package com.example.crudemployeetutorial.controller;

import com.example.crudemployeetutorial.model.Employee;
import com.example.crudemployeetutorial.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employees")
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employeeRequest){
        Employee employee = employeeService.create(employeeRequest);

        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(employeeService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable(name="id") Long id, @RequestBody Employee employeeRequest){
        Employee employee = employeeService.update(id, employeeRequest);

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Long id){
        employeeService.delete(id);

        return ResponseEntity.ok("Success");
    }
}
