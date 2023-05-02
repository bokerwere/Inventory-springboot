package com.strathmore.inventoryapplication.Stock.Entity;

import com.strathmore.inventoryapplication.Common.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "stocks")
public class StockEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "stock_code")
    private Long stockCode;
    // Foreign key referencing Item
    @Column(name = "item_code")
    private Long itemCode;
    // Foreign key referencing supplier
    @Column(name = "supplier_code")
    private Long supplierCode;
    @Column(name = "stock_quantity")
    private Long stockQuantity;
//    @ManyToOne
//    @JoinColumn(name = "item_code", nullable=false, insertable = false, updatable = false)
//    private ItemEntity itemEntity;

}
