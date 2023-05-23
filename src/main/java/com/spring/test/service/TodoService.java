package com.spring.test.service;

import java.util.List;
import java.util.Optional;

import com.spring.test.data.model.Todo;

/**
 * A service for managing todo's.
 */
public interface TodoService {

    /**
     * Creates a new todo.
     *
     * @param todo the todo to create
     * @return the created todo
     */
    Todo createTodo(Todo todo);

    /**
     * Retrieves a todo by its id.
     *
     * @param id the id of the todo to retrieve
     * @return the retrieved todo or empty optional if it was not found
     */
    Optional<Todo> retrieveTodoById(Long id);

    /**
     * Retrieves all the todo.
     *
     * @return the list of found todo's
     */
    List<Todo> retrieveAllTodo();

    /**
     * Updates an existing todo.
     *
     * @param todo the todo to update
     * @return the updated todo
     */
    Todo updateTodo(Todo todo);

    /**
     * Deletes a todo by its id.
     *
     * @param id the id of the todo to delete
     */
    void deleteTodoById(Long id);

     /**
     * Toggles a todo is completed state.
     *
     * @param id the id of the todo to toggle state
     */
    void toggleTodoState(Long id);
}