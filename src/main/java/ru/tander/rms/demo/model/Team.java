package ru.tander.rms.demo.model;

import lombok.Data;

@Data
public class Team {
    private Long id;
    private String name;
    private String email;
    private String position;
}
