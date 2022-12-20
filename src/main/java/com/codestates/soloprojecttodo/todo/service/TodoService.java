package com.codestates.soloprojecttodo.todo.service;

import com.codestates.soloprojecttodo.todo.entity.Todo;
import com.codestates.soloprojecttodo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findTodo(Long todoId) {
        return verifiedTodo(todoId);
    }

    public Page<Todo> findTodos(int page, int size) {
        return todoRepository.findAll(PageRequest.of(page - 1, size, Sort.by("todoId").descending()));
    }

    @Transactional
    public Todo updateTodo(Todo todo) {
        Todo findTodo = verifiedTodo(todo.getTodoId());

        Optional.ofNullable(todo.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.getOrder())
                .ifPresent(order -> findTodo.setOrder(order));
        Optional.ofNullable(todo.isCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        Todo findTodo = verifiedTodo(todoId);
        todoRepository.delete(findTodo);
    }

    private Todo verifiedTodo(Long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        Todo findTodo = optionalTodo
                .orElseThrow(() -> new RuntimeException("Todo를 찾을 수 없습니다."));

        return findTodo;
    }
}