package com.filtec.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Room {
    private Long id;
    private Integer roomNumber;
    private Integer totalSeats;
}
