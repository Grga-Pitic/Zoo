package org.pet.main.controller.app;

import org.pet.main.model.Animal;
import org.pet.main.model.Employee;
import org.pet.main.repository.AnimalRepository;
import org.pet.main.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    private AnimalRepository animalRepository;
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    public void setAnimalRepository(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
