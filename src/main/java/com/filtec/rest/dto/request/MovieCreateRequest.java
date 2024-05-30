package com.filtec.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieCreateRequest {
    private String name;
    private String synopsis;
    private String ageGroup;
    private String category;
    private LocalDate releaseDate;
    private LocalTime duration;
    private String director;
    private String movieCast;
    private String producer;
}