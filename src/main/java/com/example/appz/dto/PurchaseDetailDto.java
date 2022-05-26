package com.example.appz.dto;

import com.example.appz.models.Subscription;
import lombok.Data;

@Data
public class PurchaseDetailDto {
    private String type;
    private String startedAt;
    private String endedAt;

    private String username;
    private String email;

    private String status;
    private int price;
    private String paymentSystem;
}
