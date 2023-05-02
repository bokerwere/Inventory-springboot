package com.strathmore.inventoryapplication.Supplier.Repository;

import com.strathmore.inventoryapplication.Supplier.Entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Long> {
    Optional<SupplierEntity> findByPublicId(UUID publicId);
}
