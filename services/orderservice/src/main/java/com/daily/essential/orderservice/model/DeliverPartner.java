package com.daily.essential.orderservice.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "deliver_partner")
public class DeliverPartner
{
    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotEmpty
    @Column(name="name", nullable=false)
    String name;
    @NotEmpty
    @Column(name="phoneno1", nullable=false)
    String phoneno1;
    @NotEmpty
    @Column(name="phoneno2", nullable=false)
    String phoneno2;
    @NotEmpty
    @Column(name="email", nullable=false)
    String email;

    public DeliverPartner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno1() {
        return phoneno1;
    }

    public void setPhoneno1(String phoneno1) {
        this.phoneno1 = phoneno1;
    }

    public String getPhoneno2() {
        return phoneno2;
    }

    public void setPhoneno2(String phoneno2) {
        this.phoneno2 = phoneno2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "did", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<DeliverStatus> listOfDeliverStaus;
}
