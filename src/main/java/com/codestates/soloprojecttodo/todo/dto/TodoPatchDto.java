package com.codestates.soloprojecttodo.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class TodoPatchDto {

    private Long todoId;

    @NotBlank(message = "내용이 공백이 아니어야 합니다.")
    private String title;

    private Long order;

    private boolean completed;

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }
}