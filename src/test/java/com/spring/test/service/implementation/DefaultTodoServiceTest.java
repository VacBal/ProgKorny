package com.spring.test.service.implementation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.test.data.model.Todo;
import com.spring.test.data.repository.Repository;
import com.spring.test.service.TodoService;

/**
 * Unit tests for {@link DefaultTodoService}.
 */
class DefaultTodoServiceTest {

    private static final Long DUMMY_TODO_ID = 1L;
    private static final Todo DUMMY_TODO = new Todo(DUMMY_TODO_ID, "title", false);

    @Mock
    private Repository<Todo, Long> todoRepository;

    private TodoService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultTodoService(todoRepository);
    }

    @Test
    void createTodoShouldDelegateToTheRepositoryAndReturnSavedTodo() {
        // Given
        given(todoRepository.save(DUMMY_TODO)).willReturn(DUMMY_TODO);

        // When
        final Todo actual = underTest.createTodo(DUMMY_TODO);

        // Then
        assertThat(actual, equalTo(DUMMY_TODO));
        verify(todoRepository).save(DUMMY_TODO);
        verifyNoMoreInteractions(todoRepository);
    }

    @Test
    void retrieveTodoByIdShouldDelegateToTheRepositoryAndReturnFoundTodo() {
        // Given
        given(todoRepository.getById(DUMMY_TODO_ID)).willReturn(Optional.of(DUMMY_TODO));

        // When
        final Optional<Todo> actual = underTest.retrieveTodoById(DUMMY_TODO_ID);

        // Then
        assertThat(actual, equalTo(Optional.of(DUMMY_TODO)));
        verify(todoRepository).getById(DUMMY_TODO_ID);
        verifyNoMoreInteractions(todoRepository);
    }

    @Test
    void retrieveAllTodoShouldDelegateToTheRepositoryAndReturnAllFoundTodo() {
        // Given
        given(todoRepository.getAll()).willReturn(List.of(DUMMY_TODO));

        // When
        final List<Todo> actual = underTest.retrieveAllTodo();

        // Then
        assertThat(actual, equalTo(List.of(DUMMY_TODO)));
        verify(todoRepository).getAll();
        verifyNoMoreInteractions(todoRepository);
    }
}