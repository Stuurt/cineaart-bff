package com.filtec.rest.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SessionCreateRequest {
    private LocalDateTime sessionStartTime;
    private LocalDateTime sessionEndTime;
    private BigDecimal basePrice;
}
