package com.ahmetov.notes.service;

import com.ahmetov.notes.domain.Note;
import com.ahmetov.notes.dto.NoteDto;
import com.ahmetov.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    private static List<Note> notes = new ArrayList<>(
            Arrays.asList(
                    new Note(1, "Title 1", "Description 1"),
                    new Note(2, "Title 2", "Description 2"),
                    new Note(3, "Title 3", "Description 3")
            )
    );

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note getNoteById(int id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.orElse(null);
    }

    //TODO return Note
    public Note createNote(NoteDto noteDto) {
        Note note = noteRepository.save(Note.of(noteDto));
        return note;
    }

    //TODO refactor (stream API)
    public Note getNoteByIdMock(@PathVariable int id) {
        Note responseNote = notes.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
        return responseNote;
    }
    
    public List<Note> getAllMock() {
        return notes;
    }
}
