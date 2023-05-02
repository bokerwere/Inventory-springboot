package com.strathmore.inventoryapplication.Supplier.Entity;

import com.strathmore.inventoryapplication.Common.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "supplies")
public class SupplierEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "supplier_code")
    private Long supplierCode;
    // Foreign key referencing Item
    @Column(name = "item_code")
    private Long itemCode;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name="supplier_phone_no")
    private String supplierPhoneNo;
    @Column(name="supplier_email")
    private String supplierEmail;
    @Column(name = "supplier_desc")
    private String supplierDescription;

}
