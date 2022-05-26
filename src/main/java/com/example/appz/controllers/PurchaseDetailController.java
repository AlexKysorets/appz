package com.example.appz.controllers;

import com.example.appz.models.PurchaseDetail;
import com.example.appz.models.User;
import com.example.appz.services.PurchaseDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchase-details")
@RequiredArgsConstructor
public class PurchaseDetailController {
    private final PurchaseDetailService purchaseDetailService;

    @GetMapping("")
    public ResponseEntity<List<PurchaseDetail>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                       @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(purchaseDetailService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PurchaseDetail>> getById(@PathVariable int id) {
        return ResponseEntity.ok(purchaseDetailService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PurchaseDetail> create(@RequestBody PurchaseDetail purchaseDetail) {
        return ResponseEntity.ok(purchaseDetailService.save(purchaseDetail));
    }

    @PutMapping("/update")
    public ResponseEntity<PurchaseDetail> update(@RequestBody PurchaseDetail purchaseDetail) {
        return ResponseEntity.ok(purchaseDetailService.save(purchaseDetail));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<PurchaseDetail>> delete(@PathVariable int id) {
        return ResponseEntity.ok(purchaseDetailService.delete(id));
    }
}
