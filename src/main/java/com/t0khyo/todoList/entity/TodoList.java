package com.t0khyo.todoList.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo_list")
@NoArgsConstructor
@Getter
@Setter
public class TodoList {

    // NOTE: mappedBy Refers to "todoList" property in "Task" class
    // Note: @JsonManagedReference Mark the 'tasks' property as the managed side of the relationship
    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    // constructors
    public TodoList(String name) {
        this.name = name;
    }

    // custom getters/setters
    // Note: returns an empty ArrayList if tasks list is null
    public List<Task> getTasks() {
        return (tasks != null) ? tasks : new ArrayList<>();
    }

    public int getTaskCount() {
        // Calculate the number of tasks
        return (tasks != null) ? tasks.size() : 0;
    }

    // toString
    @Override
    public String toString() {
        return "TodoList{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", taskCount=" + this.getTaskCount() +
                '}';
    }
}
