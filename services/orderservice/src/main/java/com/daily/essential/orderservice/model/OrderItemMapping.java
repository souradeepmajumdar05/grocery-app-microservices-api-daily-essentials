package com.daily.essential.orderservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_item_mapping")
public class OrderItemMapping
{
    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @Column(name="oid", nullable=false)
    Integer oid;
    @NotNull
    @Column(name="itemid", nullable=false)
    Integer itemid;
    @NotNull
    @Column(name="qty", nullable=false)
    Integer qty;
    @NotEmpty
    @Column(name="qtytype", nullable=false)
    String qtytype;
    @NotEmpty
    @Column(name="status", nullable=false)
    String status;

    public OrderItemMapping(@NotEmpty Integer oid, @NotEmpty Integer itemid, @NotEmpty Integer qty, @NotEmpty String qtytype, @NotEmpty String status) {
        this.oid = oid;
        this.itemid = itemid;
        this.qty = qty;
        this.qtytype = qtytype;
        this.status = status;
    }

    public OrderItemMapping() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getQtytype() {
        return qtytype;
    }

    public void setQtytype(String qtytype) {
        this.qtytype = qtytype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
