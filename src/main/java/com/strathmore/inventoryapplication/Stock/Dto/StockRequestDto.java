package com.strathmore.inventoryapplication.Stock.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StockRequestDto {
    private Long itemCode;
    private Long supplierCode;
    private Long stockQuantity;
}
