package com.strathmore.inventoryapplication.Supplier.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SupplierRequestDto {
    public UUID publicId;
    private Long itemCode;
    private String supplierName;
    private String supplierDescription;
    private String supplierPhoneNo;
    private String supplierEmail;

}
