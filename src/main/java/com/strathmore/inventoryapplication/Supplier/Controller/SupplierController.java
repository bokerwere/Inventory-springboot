package com.strathmore.inventoryapplication.Supplier.Controller;

import com.strathmore.inventoryapplication.Supplier.Dto.SupplierRequestDto;
import com.strathmore.inventoryapplication.Supplier.Entity.SupplierEntity;
import com.strathmore.inventoryapplication.Supplier.Service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier/")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/create/")
    public ResponseEntity<SupplierEntity> createSupplier(@RequestBody SupplierRequestDto supplierRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSuppliers(supplierRequestDto));
    }
    @PostMapping("/update/")
    public ResponseEntity<SupplierEntity> updateSupplier(@RequestBody SupplierRequestDto supplierRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.updateSuppliers(supplierRequestDto));
    }
    @GetMapping("/findAll/")
    public ResponseEntity<List<SupplierEntity>>findAllSuppliers(){
        return (ResponseEntity.ok(supplierService.findAll()));
    }
}
