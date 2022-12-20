package com.codestates.soloprojecttodo.todo.mapper;

import com.codestates.soloprojecttodo.todo.dto.TodoPatchDto;
import com.codestates.soloprojecttodo.todo.dto.TodoPostDto;
import com.codestates.soloprojecttodo.todo.dto.TodoResponseDto;
import com.codestates.soloprojecttodo.todo.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostToTodo(TodoPostDto todoPostDto);

    Todo todoPatchToTodo(TodoPatchDto todoPatchDto);

    TodoResponseDto todoToTodoResponse(Todo todo);

    List<TodoResponseDto> todosToTodoResponses(List<Todo> todos);
}