package org.pet.main.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
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
