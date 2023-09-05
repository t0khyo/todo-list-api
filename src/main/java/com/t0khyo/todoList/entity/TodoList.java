package com.t0khyo.todoList.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo_list")
public class TodoList {

    // NOTE: mappedBy Refers to "todoList" property in "Task" class
    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    List<Task> tasks;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    // constructors
    public TodoList() {
    }

    public TodoList(String name) {
        this.name = name;
    }

    // getters/setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("todo-list name cannot be empty");
        }
        this.name = name;
    }

    // Adds a task to this todoList's tasks and maintains the bi-directional relationship.
    public void addTask(Task theTask) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(theTask);
        theTask.setTodoList(this);
    }

    // toString
    @Override
    public String toString() {
        int taskCount = tasks != null ? tasks.size() : 0; // Calculate the number of tasks
        return "TodoList{" +
                "tasks=" + taskCount + // Append the task count
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
