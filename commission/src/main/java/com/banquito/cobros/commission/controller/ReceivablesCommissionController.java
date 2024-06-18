package com.banquito.cobros.commission.controller;

import com.banquito.cobros.commission.model.ReceivablesCommission;
import com.banquito.cobros.commission.service.ReceivablesCommissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("/receivablescommissions")
public class ReceivablesCommissionController {

    private final ReceivablesCommissionService receivablesCommissionService;

    public ReceivablesCommissionController(ReceivablesCommissionService receivablesCommissionService) {
        this.receivablesCommissionService = receivablesCommissionService;
    }

    @GetMapping
    public ResponseEntity<List<ReceivablesCommission>> getAllReceivablesCommissions() {
        try {
            List<ReceivablesCommission> receivablesCommissions = receivablesCommissionService
                    .getAllReceivablesCommissions();
            return ResponseEntity.ok(receivablesCommissions);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceivablesCommission> getReceivablesCommissionById(@PathVariable Long id) {
        try {
            Optional<ReceivablesCommission> receivablesCommission = receivablesCommissionService
                    .getReceivablesCommissionById(id);
            return receivablesCommission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ReceivablesCommission> createReceivablesCommission(
            @RequestBody ReceivablesCommission receivablesCommission) {
        try {
            ReceivablesCommission createdReceivablesCommission = receivablesCommissionService
                    .saveReceivablesCommission(receivablesCommission);
            return ResponseEntity.ok(createdReceivablesCommission);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceivablesCommission> updateReceivablesCommission(@PathVariable Long id,
            @RequestBody ReceivablesCommission receivablesCommissionDetails) {
        try {
            Optional<ReceivablesCommission> receivablesCommissionOptional = receivablesCommissionService
                    .getReceivablesCommissionById(id);
            if (receivablesCommissionOptional.isPresent()) {
                ReceivablesCommission receivablesCommission = receivablesCommissionOptional.get();
                receivablesCommission.setCommissionId(receivablesCommissionDetails.getCommissionId());
                receivablesCommission.setReceivablesId(receivablesCommissionDetails.getReceivablesId());
                ReceivablesCommission updatedReceivablesCommission = receivablesCommissionService
                        .saveReceivablesCommission(receivablesCommission);
                return ResponseEntity.ok(updatedReceivablesCommission);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceivablesCommission(@PathVariable Long id) {
        try {
            Optional<ReceivablesCommission> receivablesCommissionOptional = receivablesCommissionService
                    .getReceivablesCommissionById(id);
            if (receivablesCommissionOptional.isPresent()) {
                receivablesCommissionService.deleteReceivablesCommission(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
