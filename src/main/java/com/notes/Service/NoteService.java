package com.notes.Service;

import com.notes.entity.Note;

import java.util.List;

public interface NoteService {
    Note getNoteById(Integer id);
    void saveNote(Note note);
    void updateNote(Integer id, String message);
    void deleteNote(Integer id);
    List<Note> findAllByOrderByDateAsc();
    List<Note> findAllByOrderByDateDesc();
}
