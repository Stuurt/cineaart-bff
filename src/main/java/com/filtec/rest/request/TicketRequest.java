package com.filtec.rest.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketRequest implements Serializable {
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private Integer seatNumber;
}
