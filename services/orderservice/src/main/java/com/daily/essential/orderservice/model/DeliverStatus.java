package com.daily.essential.orderservice.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "deliver_status")
public class DeliverStatus
{
    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @Column(name="oid", nullable=false)
    Integer oid;
    @NotEmpty
    @Column(name="status", nullable=false)
    String status;
    @NotEmpty
    @Column(name="comments", nullable=false)
    String comments;
    @NotEmpty
    @Column(name="did", nullable=false)
    String did;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public DeliverStatus() {
    }

    public DeliverStatus(@NotEmpty Integer oid, @NotEmpty String status, @NotEmpty String comments, @NotEmpty String did) {
        this.oid = oid;
        this.status = status;
        this.comments = comments;
        this.did = did;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }





}
