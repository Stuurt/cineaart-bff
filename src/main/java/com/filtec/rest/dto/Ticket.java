package com.filtec.rest.dto;

import com.filtec.domain.enums.DiscountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Long id;
    private String uuid;
    private BigDecimal pricePaid;
    private DiscountTypeEnum discountType;
}