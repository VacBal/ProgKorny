package com.spring.test.data.model;

import java.util.Objects;

/**
 * Model class for todo.
 */

 public class Todo {
    private Long id;
    private String title;
    private boolean isCompleted;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    public Todo(Long id, String title, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Todo todo = (Todo) o;

        if (!Objects.equals(id, todo.id)) {
            return false;
        }
        if (!Objects.equals(title, todo.title)) {
            return false;
        }
        if (!Objects.equals(isCompleted, todo.isCompleted)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Todo{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", isCompleted='" + isCompleted
                + '}';
    }
 }