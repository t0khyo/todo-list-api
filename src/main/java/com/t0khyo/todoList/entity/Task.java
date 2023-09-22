package com.t0khyo.todoList.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @Column(name = "dueDate")
    private LocalDate dueDate;

    @JsonIgnoreProperties("tasks") // Ignore 'tasks' property when serializing to JSON
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    // constructors
    public Task() {
        this.status = TaskStatus.INCOMPLETE;
    }

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.status = TaskStatus.INCOMPLETE;
        this.dueDate = dueDate;
    }

    // toString
    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", title='" + title + '\'' + ", status=" + status + ", dueDate=" + dueDate + ", todoList=" + todoList.getName() + '}';
    }
}
