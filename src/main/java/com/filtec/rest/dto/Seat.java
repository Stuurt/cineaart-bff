package com.filtec.rest.dto;

import com.filtec.domain.enums.SeatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Seat {
    private Long id;
    private Integer seatNumber;
    private Boolean available;
    private SeatTypeEnum type;
    private Ticket ticket;
}