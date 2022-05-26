package com.example.appz.utils;

import com.example.appz.dto.PurchaseDetailDto;
import com.example.appz.models.PurchaseDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    public PurchaseDetailDto mapToPurchaseDetailDto(PurchaseDetail purchaseDetail) {
        PurchaseDetailDto dto = new PurchaseDetailDto();

        dto.setType(purchaseDetail.getSubscription().getType());
        dto.setStartedAt(purchaseDetail.getSubscription().getStartedAt());
        dto.setEndedAt(purchaseDetail.getSubscription().getEndedAt());

        dto.setUsername(purchaseDetail.getSubscription().getUser().getUsername());
        dto.setEmail(purchaseDetail.getSubscription().getUser().getEmail());

        dto.setStatus(purchaseDetail.getStatus());
        dto.setPrice(100);
        dto.setPaymentSystem("PayPal");

        return dto;
    }
}
