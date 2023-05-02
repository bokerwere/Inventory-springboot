package com.strathmore.inventoryapplication.Items.Repository;

import com.strathmore.inventoryapplication.Items.Entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    Optional<ItemEntity>findByItemCode(Long ItemCode);
    Optional<ItemEntity> findByPublicId(UUID publicId);
    //Page<ItemEntity>findAll(Pageable pageable);
}
