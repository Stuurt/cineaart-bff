package com.filtec.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Movie {
    private Long id;
    private String name;
    private String synopsis;
    private String ageGroup;
    private String category;
    private LocalDate releaseDate;
    private String duration;
    private String director;
    private String movieCast;
    private String producer;
}