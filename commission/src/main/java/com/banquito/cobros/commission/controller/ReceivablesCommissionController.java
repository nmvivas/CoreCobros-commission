package com.banquito.cobros.commission.controller;

import com.banquito.cobros.commission.dto.ReceivablesCommissionDTO;
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
    public ResponseEntity<List<ReceivablesCommissionDTO>> getAllReceivablesCommissions() {
        try {
            List<ReceivablesCommissionDTO> receivablesCommissions = receivablesCommissionService
                    .getAllReceivablesCommissions();
            return ResponseEntity.ok(receivablesCommissions);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceivablesCommissionDTO> getReceivablesCommissionById(@PathVariable Long id) {
        try {
            Optional<ReceivablesCommissionDTO> receivablesCommission = receivablesCommissionService
                    .getReceivablesCommissionById(id);
            return receivablesCommission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ReceivablesCommissionDTO> createReceivablesCommission(
            @RequestBody ReceivablesCommissionDTO receivablesCommissionDTO) {
        try {
            ReceivablesCommissionDTO createdReceivablesCommission = receivablesCommissionService
                    .saveReceivablesCommission(receivablesCommissionDTO);
            return ResponseEntity.ok(createdReceivablesCommission);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceivablesCommissionDTO> updateReceivablesCommission(@PathVariable Long id,
            @RequestBody ReceivablesCommissionDTO receivablesCommissionDTO) {
        try {
            Optional<ReceivablesCommissionDTO> receivablesCommissionOptional = receivablesCommissionService
                    .getReceivablesCommissionById(id);
            if (receivablesCommissionOptional.isPresent()) {
                ReceivablesCommissionDTO updatedReceivablesCommission = receivablesCommissionService
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
    public ResponseEntity<Void> deleteReceivablesCommission(@PathVariable Long id) {
        try {
            Optional<ReceivablesCommissionDTO> receivablesCommissionOptional = receivablesCommissionService
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
