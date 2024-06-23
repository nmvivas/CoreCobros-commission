package com.banquito.cobros.commission.controller;

import com.banquito.cobros.commission.dto.CommissionDTO;
import com.banquito.cobros.commission.service.CommissionService;
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
@RequestMapping("/commissions")
public class CommissionController {

    private final CommissionService commissionService;

    public CommissionController(CommissionService commissionService) {
        this.commissionService = commissionService;
    }

    @GetMapping
    public ResponseEntity<List<CommissionDTO>> getAllCommissions() {
        try {
            List<CommissionDTO> commissions = commissionService.getAllCommissions();
            return ResponseEntity.ok(commissions);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommissionDTO> getCommissionById(@PathVariable Long id) {
        try {
            Optional<CommissionDTO> commission = commissionService.getCommissionById(id);
            return commission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<CommissionDTO> createCommission(@RequestBody CommissionDTO commissionDTO) {
        try {
            CommissionDTO createdCommission = commissionService.saveCommission(commissionDTO);
            return ResponseEntity.ok(createdCommission);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommissionDTO> updateCommission(@PathVariable Long id,
            @RequestBody CommissionDTO commissionDetails) {
        try {
            CommissionDTO updatedCommission = commissionService.updateCommission(id, commissionDetails);
            return ResponseEntity.ok(updatedCommission);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommission(@PathVariable Long id) {
        try {
            commissionService.deleteCommission(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
