package com.filtec.rest.request;

import com.filtec.domain.enums.DiscountTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketRequest implements Serializable {
    @NotNull
    private Long seatId;
    @NotNull
    private UUID uuid;
    @NotNull
    private BigDecimal paidPrice;
    @NotNull
    private Integer seatNumber;
    @NotBlank
    private DiscountTypeEnum discountType;
}
