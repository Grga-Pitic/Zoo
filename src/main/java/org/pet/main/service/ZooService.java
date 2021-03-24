package org.pet.main.service;

import org.pet.main.emun.Action;
import org.pet.main.emun.AnimalState;
import org.pet.main.model.Animal;
import org.pet.main.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

    public void doAction(Animal animal, Employee employee, Action action) throws Exception {
        switch (action) {
            case FEED:
                if (animal.getState() == AnimalState.CAGE) {
                    break;
                }
                throw new Exception("Incorrect animal state");
            case CLEANUP:
                if (animal.getState() == AnimalState.AVIARY) {
                    break;
                }
                throw new Exception("Incorrect animal state");
            default:
                throw new Exception("Unknown action");
        }

        System.out.println(employee.getName() + " does action " + action.toUnderstandbleString() + " with animal " + animal.getName());
    }

}
