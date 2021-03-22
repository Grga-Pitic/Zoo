package org.pet.main.service;

import org.pet.main.emun.AnimalState;
import org.pet.main.model.Animal;
import org.pet.main.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

    public void feedAnimal(Animal animal, Employee employee) throws Exception {
        if (animal.getState() == AnimalState.CAGE) {
            System.out.println(employee.getName() + " fed the " + animal.getName());
            return;
        }
        throw new Exception("Incorrect animal stage");
    }

    public void cleanUpCage(Animal animal, Employee employee) throws Exception {
        if (animal.getState() == AnimalState.AVIARY) {
            System.out.println(employee.getName() + " cleaned the " + animal.getName() + "'s cage");
            return;
        }
        throw new Exception("Incorrect animal stage");
    }

}
