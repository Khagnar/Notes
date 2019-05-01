package com.notes.Service;

import com.notes.entity.Note;
import com.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note getNoteById(Integer id) {
        return noteRepository.getOne(id);
    }

    @Override
    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void updateNote(Integer id, String message) {
        Note update = noteRepository.getOne(id);
        update.setMessage(message);
        noteRepository.save(update);
    }

    @Override
    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> findAllByOrderByDateAsc() {
        return noteRepository.findAllByOrderByDateAsc();
    }

    @Override
    public List<Note> findAllByOrderByDateDesc() {
        return noteRepository.findAllByOrderByDateDesc();
    }
}
