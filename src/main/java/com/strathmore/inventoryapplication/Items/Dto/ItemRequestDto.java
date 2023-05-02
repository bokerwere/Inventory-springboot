package com.strathmore.inventoryapplication.Items.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequestDto {
    private UUID publicId;
    private String itemName;
    private BigDecimal itemCost;
    private Long itemSalePrice;
}
