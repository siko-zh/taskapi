package com.zholdigaliev.taskapi.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TaskStatus taskStatus;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TaskPriority taskPriority;

    public Task(String title, String description, TaskStatus taskStatus, TaskPriority taskPriority) {
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
    }
}
