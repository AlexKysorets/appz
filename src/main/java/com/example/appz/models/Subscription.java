package com.example.appz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Subscription")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscription {
    @Id
    private int id;
    @Column(name = "type")
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
//    @Column(name = "user_id")
//    private int userId;
    @Column(name = "started_at")
    private String startedAt;
    @Column(name = "ended_at")
    private String endedAt;
//    @OneToOne(mappedBy = "PurchaseDetail")
//    private PurchaseDetail purchaseDetail;
}
