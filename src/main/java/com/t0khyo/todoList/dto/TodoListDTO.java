package com.t0khyo.todoList.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoListDTO {
    @NotBlank(message = "must not be blank")
    @NotNull(message = "must not be null")
    @NotEmpty(message = "must not be empty")
    private String name;
}
