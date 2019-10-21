package com.ahmetov.notes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteDto {
    private String title;
    private String description;
}
