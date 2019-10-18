package com.ahmetov.notes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Note {
    @Id
    private Integer id;
    private String title;
    private String description;
}
