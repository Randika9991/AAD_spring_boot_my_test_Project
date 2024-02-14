package lk.ijse.demo.entity;
/*
    this application is copyright protected
    Author : kumara
    Date : 2/14/2024
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String address;

    public Address(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
