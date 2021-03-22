package org.pet.main.controller.api;

import org.pet.main.model.Animal;
import org.pet.main.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AnimalController {

    private AnimalRepository animalRepository;

    @GetMapping("/animal")
    public Iterable<Animal> getAnimal() {
        return animalRepository.findAll();
    }

    @GetMapping("/animal/{id}")
    public Optional<Animal> getAnimal(@PathVariable long id) {
        return animalRepository.findById(id);
    }

    @PostMapping("/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @DeleteMapping("/animal")
    public void deleteAnimal(@RequestBody String id) {
        animalRepository.deleteById(Long.parseLong(id));
    }

    @Autowired
    public void setAnimalRepository(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

}
