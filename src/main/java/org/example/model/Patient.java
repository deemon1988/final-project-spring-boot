package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "patients")
public class Patient {
    @Id @GeneratedValue
    private Long id;
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public Patient(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
