package com.t0khyo.todoList.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @Column(name = "dueDate")
    private LocalDate dueDate;

    @JsonIgnoreProperties("tasks") // Ignore 'tasks' property when serializing to JSON
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    // constructors

    public Task() {
        this.status = TaskStatus.INCOMPLETE;
    }

    public Task(String title, TaskStatus status, LocalDate dueDate) {
        this.setTitle(title); // the setters for checking null values
        this.setStatus(status);
        this.dueDate = dueDate;
    }

    // setters/getters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title cannot be empty");
        }
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = Objects.requireNonNullElse(status, TaskStatus.INCOMPLETE);
    }


    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }

    // toString

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", title='" + title + '\'' + ", status=" + status + ", dueDate=" + dueDate + ", todoList=" + todoList.getName() + '}';
    }
}
