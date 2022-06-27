package com.example.crudemployeetutorial.service;

import com.example.crudemployeetutorial.model.Employee;
import com.example.crudemployeetutorial.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getOne(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isEmpty()){
            throw new IllegalStateException();
        }

        return employeeOptional.get();
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee update(Long id, Employee employee){
        employee.setId(id);

        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
