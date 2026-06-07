package com.payflow.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "upi_id")
    private String upiId;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "phone_number")
    private String phoneNumber;

    public User(){

    }
    public User(String name, String upiId, Double balance, String phoneNumber){
        this.name = name;
        this.upiId = upiId;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
    }


}
