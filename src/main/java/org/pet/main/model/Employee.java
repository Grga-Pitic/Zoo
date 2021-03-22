package org.pet.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;

    public Employee() {}

    public Employee(String name) {
        this.name   = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
