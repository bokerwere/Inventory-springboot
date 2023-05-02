package com.strathmore.inventoryapplication.Common;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AppResponse {
    private String status;
    private LocalDateTime timestamp;
}
