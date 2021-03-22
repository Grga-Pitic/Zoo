package org.pet.main.controller.api;

import org.pet.main.model.Employee;
import org.pet.main.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public Iterable<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable long id) {
        return employeeRepository.findById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestBody String id) {
        employeeRepository.deleteById(Long.parseLong(id));
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

}
