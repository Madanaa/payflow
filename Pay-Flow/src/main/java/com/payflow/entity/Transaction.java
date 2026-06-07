package com.payflow.entity;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long transactionId;
    @Column(name = "sender_upi_id")
    private String senderUpiId;
    @Column(name = "receiver_upi_id")
    private String receiverUpiId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "note")
    private String note;

}

