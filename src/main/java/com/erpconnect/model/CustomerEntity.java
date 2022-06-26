package com.erpconnect.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "public", catalog = "masterdata")
public class CustomerEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private String customer_id;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "customer_name")
    private String customer_name;
    @Basic
    @Column(name = "customer_address")
    private String customer_address;
    @Basic
    @Column(name = "customer_phone")
    private String customer_phone;
    @Basic
    @Column(name = "erpconnect_private_key")
    private String erpconnect_private_key;
    @Basic
    @Column(name = "erpconnect_public_key")
    private String erpconnect_public_key;
    @Basic
    @Column(name = "customer_public_key")
    private String customer_public_key;


    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getErpconnect_private_key() {
        return erpconnect_private_key;
    }

    public void setErpconnect_private_key(String erpconnect_private_key) {
        this.erpconnect_private_key = erpconnect_private_key;
    }

    public String getErpconnect_public_key() {
        return erpconnect_public_key;
    }

    public void setErpconnect_public_key(String erpconnect_public_key) {
        this.erpconnect_public_key = erpconnect_public_key;
    }

    public String getCustomer_public_key() {
        return customer_public_key;
    }

    public void setCustomer_public_key(String customer_public_key) {
        this.customer_public_key = customer_public_key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return customer_id == that.customer_id && Objects.equals(password, that.password) && Objects.equals(customer_name, that.customer_name) && Objects.equals(customer_address, that.customer_address) && Objects.equals(customer_phone, that.customer_phone) && Objects.equals(erpconnect_private_key, that.erpconnect_private_key) && Objects.equals(erpconnect_public_key, that.erpconnect_public_key) && Objects.equals(customer_public_key, that.customer_public_key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, password, customer_name, customer_address, customer_phone, erpconnect_private_key, erpconnect_public_key, customer_public_key);
    }
}
