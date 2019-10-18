package com.ahmetov.notes.controller;

import com.ahmetov.notes.domain.Note;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO configure Spring Security
@RestController
@RequestMapping("sticky-notes")
public class MainPageResource {
    private static List<Note> notes = new ArrayList<>(
            Arrays.asList(
                    new Note(1, "Title 1", "Description 1"),
                    new Note(2, "Title 2", "Description 2"),
                    new Note(3, "Title 3", "Description 3")
            )
    );

    @ResponseBody
    @GetMapping("/get-all")
    public List<Note> getNotes() {
        return notes;
    }

    @ResponseBody
    @GetMapping("/get-note/{id}")
    public Note getNoteById(@PathVariable int id) {
        Note responseNote = null;
        for(Note n : notes) {       //TODO refactor (stream API)
            if (n.getId() == id) {
                responseNote = n;
                break;
            }
        }
        return responseNote;
    }
}
