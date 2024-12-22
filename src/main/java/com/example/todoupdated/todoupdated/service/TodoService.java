package com.example.todoupdated.todoupdated.service;


import com.example.todoupdated.todoupdated.model.Todo;
import com.example.todoupdated.todoupdated.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    public Todo getTodoById(Long id) {
        return  todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        System.out.println(todoDetails.getClass().getName());

        Todo todo = getTodoById(id);
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.isCompleted());
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
