package com.t0khyo.todoList.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo_list")
public class TodoList {

    // NOTE: mappedBy Refers to "todoList" property in "Task" class
    // Note: @JsonManagedReference Mark the 'tasks' property as the managed side of the relationship
    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Task> tasks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    private int taskCount;

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

    // Note: returns an empty ArrayList if tasks list is null
    public List<Task> getTasks() {
        return (tasks != null) ? tasks : new ArrayList<>();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    // Adds a task to this todoList's 'tasks' class member and maintains the bi-directional relationship.
    public void addTask(Task theTask) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(theTask);
        theTask.setTodoList(this);
    }

    public int getTaskCount() {
        taskCount = tasks != null ? tasks.size() : 0; // Calculate the number of tasks
        return taskCount;
    }

    // toString

    @Override
    public String toString() {
        return "TodoList{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", taskCount=" + taskCount +
                '}';
    }
}
