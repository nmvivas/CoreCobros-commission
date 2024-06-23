package com.banquito.cobros.commission.controller;

import com.banquito.cobros.commission.dto.ReceivableCommissionDTO;
import com.banquito.cobros.commission.service.ReceivableCommissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("/receivablecommissions")
public class ReceivableCommissionController {

    private final ReceivableCommissionService receivableCommissionService;

    public ReceivableCommissionController(ReceivableCommissionService receivableCommissionService) {
        this.receivableCommissionService = receivableCommissionService;
    }

    @GetMapping
    public ResponseEntity<List<ReceivableCommissionDTO>> getAllReceivableCommissions() {
        try {
            List<ReceivableCommissionDTO> receivableCommissions = receivableCommissionService
                    .getAllReceivablesCommissions();
            return ResponseEntity.ok(receivableCommissions);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceivableCommissionDTO> getReceivableCommissionById(@PathVariable Long id) {
        try {
            Optional<ReceivableCommissionDTO> receivablesCommission = receivableCommissionService
                    .getReceivablesCommissionById(id);
            return receivablesCommission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ReceivableCommissionDTO> createReceivableCommission(
            @RequestBody ReceivableCommissionDTO receivablesCommissionDTO) {
        try {
            ReceivableCommissionDTO createdReceivablesCommission = receivableCommissionService
                    .saveReceivablesCommission(receivablesCommissionDTO);
            return ResponseEntity.ok(createdReceivablesCommission);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceivableCommissionDTO> updateReceivableCommission(@PathVariable Long id,
            @RequestBody ReceivableCommissionDTO receivablesCommissionDTO) {
        try {
            Optional<ReceivableCommissionDTO> receivablesCommissionOptional = receivableCommissionService
                    .getReceivablesCommissionById(id);
            if (receivablesCommissionOptional.isPresent()) {
                ReceivableCommissionDTO updatedReceivablesCommission = receivableCommissionService
                        .saveReceivablesCommission(receivablesCommissionDTO);
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
    public ResponseEntity<Void> deleteReceivableCommission(@PathVariable Long id) {
        try {
            Optional<ReceivableCommissionDTO> receivablesCommissionOptional = receivableCommissionService
                    .getReceivablesCommissionById(id);
            if (receivablesCommissionOptional.isPresent()) {
                receivableCommissionService.deleteReceivablesCommission(id);
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