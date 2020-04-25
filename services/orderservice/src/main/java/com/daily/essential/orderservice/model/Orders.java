package com.daily.essential.orderservice.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @Column(name="uid", nullable=false)
    Integer uid;
    @NotNull
    @Column(name="total", nullable=false)
    BigDecimal total;
    @NotNull
    @Column(name="shipping_charges", nullable=false)
    BigDecimal shipping_charges;
    @NotNull
    @Column(name="de_coins", nullable=false)
    BigDecimal de_coins;
    @NotNull
    @Column(name="cod_charges", nullable=false)
    BigDecimal cod_charges;
    @NotNull
    @Column(name="total_cash_to_take", nullable=false)
    BigDecimal total_cash_to_take;
    @NotEmpty
    @Column(name="status", nullable=false)
    String status;
    @NotNull
    @Column(name="courier_partner_id", nullable=false)
    Integer courier_partner_id;
   // @NotEmpty
    @Column(name="ETA"/*, nullable=false*/)
    Timestamp ETA;
    //@NotEmpty
    @Column(name="creation_date"/*, nullable=false*/)
    Timestamp creation_date;
    @NotNull
    @Column(name="active", nullable=false)
    Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getShipping_charges() {
        return shipping_charges;
    }

    public void setShipping_charges(BigDecimal shipping_charges) {
        this.shipping_charges = shipping_charges;
    }

    public BigDecimal getDe_coins() {
        return de_coins;
    }

    public void setDe_coins(BigDecimal de_coins) {
        this.de_coins = de_coins;
    }

    public BigDecimal getCod_charges() {
        return cod_charges;
    }

    public void setCod_charges(BigDecimal cod_charges) {
        this.cod_charges = cod_charges;
    }

    public BigDecimal getTotal_cash_to_take() {
        return total_cash_to_take;
    }

    public void setTotal_cash_to_take(BigDecimal total_cash_to_take) {
        this.total_cash_to_take = total_cash_to_take;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCourier_partner_id() {
        return courier_partner_id;
    }

    public void setCourier_partner_id(Integer courier_partner_id) {
        this.courier_partner_id = courier_partner_id;
    }

    public Timestamp getETA() {
        return ETA;
    }

    public void setETA(Timestamp ETA) {
        this.ETA = ETA;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Boolean getActive() {
        return active;
    }


    public List<OrderItemMapping> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<OrderItemMapping> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public List<DeliverStatus> getListDeliverStatus() {
        return listOfDeliverStatus;
    }

    public void setListDeliverStatus(List<DeliverStatus> listOfDeliverStatus) {
        this.listOfDeliverStatus = listOfDeliverStatus;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    @OneToMany(mappedBy = "oid", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<OrderItemMapping> listOfItems;


    @OneToMany(mappedBy = "oid", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<DeliverStatus> listOfDeliverStatus;

}
