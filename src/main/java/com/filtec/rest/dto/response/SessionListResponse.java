package com.filtec.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.filtec.rest.dto.Movie;
import com.filtec.rest.dto.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionListResponse {
    private Long id;
    private LocalDateTime sessionStartTime;
    private LocalDateTime sessionEndTime;
    private BigDecimal basePrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Movie movie;
    private Room room;
}
