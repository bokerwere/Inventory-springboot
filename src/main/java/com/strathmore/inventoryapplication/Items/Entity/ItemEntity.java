package com.strathmore.inventoryapplication.Items.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.strathmore.inventoryapplication.Common.BaseEntity;
import com.strathmore.inventoryapplication.Stock.Entity.StockEntity;
import com.strathmore.inventoryapplication.Supplier.Entity.SupplierEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "items")
public class ItemEntity extends BaseEntity {
    @JsonIgnore
    @OneToMany(mappedBy = "itemCode", cascade = CascadeType.REMOVE)
    List<SupplierEntity> supplierEntityList;
    @JsonIgnore
    @OneToMany(mappedBy = "itemCode", cascade = CascadeType.REMOVE)
    List<StockEntity> stockEntityList;
    @Id
    @GeneratedValue
    @Column(name = "item_code")
    private Long itemCode;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_cost")
    private BigDecimal itemCost;
    @Column(name = "item_sale_price")
    private Long itemSalePrice;


}


