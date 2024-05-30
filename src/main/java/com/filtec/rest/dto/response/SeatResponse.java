package com.filtec.rest.dto.response;

import com.filtec.domain.enums.SeatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class SeatResponse {
    private Long id;
    private Integer seatNumber;
    private Boolean available;
    private SeatTypeEnum type;
}
