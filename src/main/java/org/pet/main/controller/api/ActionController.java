package org.pet.main.controller.api;

import org.pet.main.emun.Action;
import org.pet.main.model.Animal;
import org.pet.main.model.Employee;
import org.pet.main.repository.AnimalRepository;
import org.pet.main.repository.EmployeeRepository;
import org.pet.main.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ActionController {

    private EmployeeRepository employeeRepository;
    private AnimalRepository animalRepository;

    private ZooService service;

    @PostMapping("/action")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void doAction(@RequestBody ActionData data) throws Exception {
        Animal animal = animalRepository.findById(data.getAnimalId()).get();
        Employee employee = employeeRepository.findById(data.getEmployeeId()).get();
        service.doAction(animal, employee, data.getAction());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleIOException(Exception e) {
        Map<String, String> body = new HashMap<String, String>();
        body.put("message", "Application error: " + e.getMessage());
        return body;
    }

    @Autowired
    public void setService(ZooService service) {
        this.service = service;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setAnimalRepository(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    private static class ActionData {
        private long employeeId;

        private long animalId;

        private Action action;

        public long getEmployeeId() {
            return employeeId;
        }

        public long getAnimalId() {
            return animalId;
        }

        public Action getAction() {
            return action;
        }
    }

}
