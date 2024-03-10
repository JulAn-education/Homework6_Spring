package ru.gb.Homework6_Spring.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.Homework6_Spring.models.Note;
import ru.gb.Homework6_Spring.repositoryes.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteServices {
  @Autowired
  private NoteRepository noteRepo;
    public List<Note> getAll(){
        return noteRepo.findAll();
    }

    public void save(Note note){
        noteRepo.save(note);
    }

    public Note getById(Long id){
        return noteRepo.findById(id).get();
    }

    public void delete(Long id){
        noteRepo.deleteById(id);
    }

    public void updateNote(Long id, Note note){
        Note notes = noteRepo.findById(id).orElse(null);
        if(notes != null){
            notes.setContent(note.getContent());
            notes.setTitle(note.getTitle());
            notes.setDate(LocalDateTime.now());
            noteRepo.save(notes);
        }else {
            throw new IllegalArgumentException();
        }
    }



}
