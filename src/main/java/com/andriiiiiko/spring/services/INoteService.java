package com.andriiiiiko.spring.services;

import com.andriiiiiko.spring.entities.Note;
import com.andriiiiiko.spring.exceptions.NotesNotFoundExceptions;

import java.util.Map;

public interface INoteService {

    Map<Long, Note> listAll();

    Note add(Note entity);

    void deleteById(Long id) throws NotesNotFoundExceptions;

    void update(Long id, Note entity) throws NotesNotFoundExceptions;

    Note getById(Long id) throws NotesNotFoundExceptions;
}
