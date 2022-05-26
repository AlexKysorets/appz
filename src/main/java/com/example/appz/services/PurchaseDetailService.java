package com.example.appz.services;

import com.example.appz.models.PurchaseDetail;
import com.example.appz.models.User;
import com.example.appz.repositories.PurchaseDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseDetailService {
    private final PurchaseDetailRepository purchaseDetailRepository;

    public List<PurchaseDetail> getAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var purchaseDetails = purchaseDetailRepository.findAll(paging);
        return purchaseDetails.toList();
    }

    public Optional<PurchaseDetail> getById(int id) {
        return purchaseDetailRepository.findById(id);
    }

    public PurchaseDetail save(PurchaseDetail purchaseDetail) {
        return purchaseDetailRepository.save(purchaseDetail);
    }

    public Optional<PurchaseDetail> delete(int id) {
        var purchaseDetail = this.getById(id);
        purchaseDetailRepository.deleteById(id);
        return purchaseDetail;
    }
}
