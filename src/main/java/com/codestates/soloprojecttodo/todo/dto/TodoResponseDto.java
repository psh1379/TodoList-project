package com.codestates.soloprojecttodo.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TodoResponseDto {
    private Long todoId;
    private String title;
    private Long order;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}