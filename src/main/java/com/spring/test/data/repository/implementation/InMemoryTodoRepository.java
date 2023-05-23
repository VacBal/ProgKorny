package com.spring.test.data.repository.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.test.data.model.Todo;
import com.spring.test.data.repository.Repository;

/**
 * Map-based in-memory implementation of {@link Repository}.
 */
@org.springframework.stereotype.Repository
public class InMemoryTodoRepository implements Repository<Todo, Long> {

    private static final Map<Long, Todo> STORAGE = new HashMap<>();

    @Override
    public Todo save(Todo todo) {
        Long id = STORAGE.size() + 1L;
        todo.setId(id);
        STORAGE.put(id, todo);
        return STORAGE.get(id);
    }

    @Override
    public Optional<Todo> getById(Long id) {
        return Optional.ofNullable(STORAGE.get(id));
    }

    @Override
    public List<Todo> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Todo update(Todo todo) {
        Long id = todo.getId();
        STORAGE.put(id, todo);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}