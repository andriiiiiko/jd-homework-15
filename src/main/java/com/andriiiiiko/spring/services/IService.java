package com.andriiiiiko.spring.services;

import com.andriiiiiko.spring.exceptions.NotesNotFoundExceptions;

import java.util.Map;

public interface IService<T> {

    Map<Long, T> listAll();

    T add(T entity);

    void deleteById(Long id) throws NotesNotFoundExceptions;

    void update(Long id, T entity) throws NotesNotFoundExceptions;

    T getById(Long id) throws NotesNotFoundExceptions;
}
