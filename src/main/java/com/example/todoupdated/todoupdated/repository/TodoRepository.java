package com.example.todoupdated.todoupdated.repository;

import com.example.todoupdated.todoupdated.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
