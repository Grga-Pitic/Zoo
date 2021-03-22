package org.pet.main.model;

import org.pet.main.emun.AnimalState;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private AnimalState state;

    public Animal() {}

    public Animal(String name) {
        this.name           = name;
        this.state          = AnimalState.CAGE;
    }

    public void setState(AnimalState state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public AnimalState getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
