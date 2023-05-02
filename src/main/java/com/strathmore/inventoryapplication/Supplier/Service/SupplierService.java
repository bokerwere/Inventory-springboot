package com.strathmore.inventoryapplication.Supplier.Service;

import com.strathmore.inventoryapplication.Supplier.Dto.SupplierRequestDto;
import com.strathmore.inventoryapplication.Supplier.Entity.SupplierEntity;

import java.util.List;

public interface SupplierService {
   SupplierEntity createSuppliers(SupplierRequestDto supplierRequestDto) ;

    SupplierEntity updateSuppliers(SupplierRequestDto supplierRequestDto);
    List<SupplierEntity>findAll();
}
