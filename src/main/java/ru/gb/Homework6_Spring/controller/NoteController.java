package ru.gb.Homework6_Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.Homework6_Spring.models.Note;
import ru.gb.Homework6_Spring.services.NoteServices;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteServices noteServices;
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        note.setDate(LocalDateTime.now());
        noteServices.save(note);
        return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.ok(noteServices.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        return ResponseEntity.ok(noteServices.getById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        noteServices.updateNote(id, note);
        return ResponseEntity.ok(noteServices.getById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id){
        Note note = noteServices.getById(id);
        noteServices.delete(id);
        return ResponseEntity.ok(note);
    }

}












