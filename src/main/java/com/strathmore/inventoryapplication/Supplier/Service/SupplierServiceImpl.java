package com.strathmore.inventoryapplication.Supplier.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strathmore.inventoryapplication.Exception.ResourceNotFoundException;
import com.strathmore.inventoryapplication.Supplier.Dto.SupplierRequestDto;
import com.strathmore.inventoryapplication.Supplier.Entity.SupplierEntity;
import com.strathmore.inventoryapplication.Supplier.Repository.SupplierRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @SneakyThrows
    @Override
    public SupplierEntity createSuppliers(SupplierRequestDto supplierRequestDto) {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setSupplierCode(supplierEntity.getSupplierCode());
        supplierEntity.setItemCode(supplierRequestDto.getItemCode());
        supplierEntity.setSupplierName(supplierRequestDto.getSupplierName());
        supplierEntity.setSupplierDescription(supplierRequestDto.getSupplierDescription());
        supplierEntity.setSupplierEmail(supplierRequestDto.getSupplierEmail());
        supplierEntity.setSupplierPhoneNo(supplierRequestDto.getSupplierPhoneNo());
        log.info("supplierRequestBody{}", mapper.writeValueAsString(supplierEntity));
        return supplierRepository.save(supplierEntity);
    }

    @Override
    public SupplierEntity updateSuppliers(SupplierRequestDto supplierRequestDto) {
        SupplierEntity supplierEntity = supplierRepository.findByPublicId(supplierRequestDto.publicId)
                .orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        supplierEntity.setItemCode(supplierRequestDto.getItemCode());
        supplierEntity.setSupplierName(supplierRequestDto.getSupplierName());
        supplierEntity.setSupplierDescription(supplierRequestDto.getSupplierDescription());
        supplierEntity.setSupplierEmail(supplierRequestDto.getSupplierEmail());
        supplierEntity.setSupplierPhoneNo(supplierRequestDto.getSupplierPhoneNo());
        log.info("supplierRequestBody{}", supplierRequestDto);
        return supplierRepository.save(supplierEntity);
    }

    @Override
    public List<SupplierEntity> findAll() {
        return supplierRepository.findAll();
    }
}
