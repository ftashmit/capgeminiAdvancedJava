package org.example;

import jakarta.persistence.*;


//Entity  → Database mapping
//DAO     → Database operations
//DTO     → Data transfer between layers
@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;

    private String description;
    // Required by JPA
    public Task() {
    }

    // Parameterized constructor
    public Task(String task, String description) {
        this.task = task;
        this.description = description;
    }

    public Task(Long id, String task) {
        this.id = id;
        this.task = task;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }
    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}