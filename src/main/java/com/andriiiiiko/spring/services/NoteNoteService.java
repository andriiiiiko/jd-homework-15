package com.andriiiiiko.spring.services;

import com.andriiiiiko.spring.entities.Note;
import com.andriiiiiko.spring.exceptions.NotesNotFoundExceptions;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service class for managing Note entities.
 */
@Service
public class NoteNoteService implements INoteService {

    private final Map<Long, Note> notes = new ConcurrentHashMap<>();
    private final Random random = new Random();

    /**
     * Retrieve a map of all notes.
     *
     * @return A map containing all notes.
     */
    @Override
    public Map<Long, Note> listAll() {
        return notes;
    }

    /**
     * Add a new note.
     *
     * @param note The note to be added.
     * @return The added note.
     */
    @Override
    public Note add(Note note) {
        Long id = generateID();
        notes.put(id, note);
        return note;
    }

    /**
     * Generate a unique ID for a note.
     *
     * @return A unique ID for a note.
     */
    private Long generateID() {
        return Math.abs(random.nextLong());
    }

    /**
     * Delete a note by ID.
     *
     * @param id The ID of the note to delete.
     * @throws NotesNotFoundExceptions if the note with the given ID is not found.
     */
    @Override
    public void deleteById(Long id) throws NotesNotFoundExceptions {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else {
            throw new NotesNotFoundExceptions(id);
        }
    }

    /**
     * Update a note by ID.
     *
     * @param id   The ID of the note to update.
     * @param note The updated note.
     * @throws NotesNotFoundExceptions if the note with the given ID is not found.
     */
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

    /**
     * Get a note by ID.
     *
     * @param id The ID of the note to retrieve.
     * @return The note corresponding to the given ID.
     * @throws NotesNotFoundExceptions if the note with the given ID is not found.
     */
    @Override
    public Note getById(Long id) throws NotesNotFoundExceptions {
        if (notes.containsKey(id)) {
            return notes.get(id);
        } else {
            throw new NotesNotFoundExceptions(id);
        }
    }
}
