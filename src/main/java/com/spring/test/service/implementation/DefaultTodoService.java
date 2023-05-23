package com.spring.test.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.data.model.Todo;
import com.spring.test.data.repository.Repository;
import com.spring.test.service.TodoService;

/**
 * Default implementation of {@link TodoService}.
 */
@Service
public class DefaultTodoService implements TodoService {

    private final Repository<Todo, Long> todoRepository;

    @Autowired
    public DefaultTodoService(Repository<Todo, Long> todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> retrieveTodoById(Long id) {
        return todoRepository.getById(id);
    }

    @Override
    public List<Todo> retrieveAllTodo() {
        return todoRepository.getAll();
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoRepository.update(todo);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void toggleTodoState(Long id) {
        Optional<Todo> todo = todoRepository.getById(id);
        todo.ifPresent(t -> {
            t.setIsCompleted(!t.getIsCompleted());
            todoRepository.update(t);
        }); 
    }
}