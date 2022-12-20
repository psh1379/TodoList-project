package com.codestates.soloprojecttodo.todo.repository;

import com.codestates.soloprojecttodo.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, CrudRepository<Todo, Long> {
    Optional<Todo> findByOrder(Long order);
}