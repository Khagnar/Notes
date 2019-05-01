package com.notes.controller;

import com.notes.Service.NoteService;
import com.notes.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class NoteController {

    private NoteService noteService;
    private String sortDateMethod = "ASC";

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/")
    public String listNotes(Model model) {
        List<Note> listNotes = filterAndSort();
        model.addAttribute("notes", listNotes);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }

    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editNote(@PathVariable Integer id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id));
        return "operations/edit";
    }

    @GetMapping(value = "/new")
    public String newNote() {
        return "operations/new";
    }

    @PostMapping("/update")
    public String saveNote(@RequestParam Integer id, @RequestParam String message) {
        noteService.updateNote(id, message);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String updateNote(@RequestParam String message) {
        noteService.saveNote(new Note(message));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
        return "redirect:/";
    }

    private List<Note> filterAndSort() {
        List<Note> listNotes = null;
        switch (sortDateMethod) {
            case "ASC":
                listNotes = noteService.findAllByOrderByDateAsc();
                break;
            case "DESC":
                listNotes = noteService.findAllByOrderByDateDesc();
                break;
        }
        return listNotes;
    }
}
