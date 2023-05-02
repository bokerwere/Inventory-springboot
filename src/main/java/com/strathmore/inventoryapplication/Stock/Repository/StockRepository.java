package com.strathmore.inventoryapplication.Stock.Repository;

import com.strathmore.inventoryapplication.Stock.Entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity,Long> {
}
