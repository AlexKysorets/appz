package com.example.appz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PurchaseDetail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseDetail {
//    private final int price = 100;
//    private final String paymentSystem = "PayPal";

    @Id
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;
    @Column(name = "status")
    private String status;
}
