package com.ahmetov.notes.controller;

import com.ahmetov.notes.domain.Note;
import com.ahmetov.notes.dto.NoteDto;
import com.ahmetov.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO add liquibase
@RestController
@RequestMapping("sticky-notes")
@RequiredArgsConstructor
public class MainPageResource {

    private final NoteService noteService;

    @ResponseBody
    @GetMapping("/get-all")
    public List<Note> getNotes() {
        return noteService.getAll();
    }

    @ResponseBody
    @PostMapping("/add-note")
    public ResponseEntity<Note> addNote(@RequestBody NoteDto noteDto) {
        Note responseNote = noteService.createNote(noteDto);
        if (responseNote != null) {
            return new ResponseEntity<>(responseNote, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @GetMapping("/get-note/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id) {
        Note responseNote = noteService.getNoteById(id);
        if (responseNote != null) {
            return new ResponseEntity<>(responseNote, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
