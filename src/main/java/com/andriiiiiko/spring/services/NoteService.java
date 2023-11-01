package com.andriiiiiko.spring.services;

import com.andriiiiiko.spring.entities.Note;
import com.andriiiiiko.spring.exceptions.NotesNotFoundExceptions;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NoteService implements IService<Note> {

    private final Map<Long, Note> notes = new ConcurrentHashMap<>();
    private final Random random = new Random();


    @Override
    public Map<Long, Note> listAll() {
        return notes;
    }

    @Override
    public Note add(Note note) {
        Long id = generateID();
        notes.put(id, note);
        return note;
    }

    private Long generateID() {
        return Math.abs(random.nextLong());
    }

    @Override
    public void deleteById(Long id) throws NotesNotFoundExceptions {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else {
            throw new NotesNotFoundExceptions(id);
        }
    }

    @Override
    public void update(Long id, Note note) throws NotesNotFoundExceptions {
        if (notes.containsKey(id)) {
            Note existingNote = notes.get(id);

            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());

            notes.put(id, existingNote);
        } else {
            throw new NotesNotFoundExceptions(id);
        }
    }

    @Override
    public Note getById(Long id) throws NotesNotFoundExceptions {
        if (notes.containsKey(id)) {
            return notes.get(id);
        } else {
            throw new NotesNotFoundExceptions(id);
        }
    }
}
