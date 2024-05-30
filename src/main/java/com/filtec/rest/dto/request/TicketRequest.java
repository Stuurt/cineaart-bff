package com.filtec.rest.dto.request;

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
    private Long seatId;
    private UUID uuid;
    private BigDecimal paidPrice;
    private Integer seatNumber;
    private DiscountTypeEnum discountType;
}
