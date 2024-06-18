package com.banquito.cobros.commission.controller;

import com.banquito.cobros.commission.model.Commission;
import com.banquito.cobros.commission.service.CommissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Commission>> getAllCommissions() {
        try {
            List<Commission> commissions = commissionService.getAllCommissions();
            return ResponseEntity.ok(commissions);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commission> getCommissionById(@PathVariable Long id) {
        try {
            Optional<Commission> commission = commissionService.getCommissionById(id);
            return commission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Commission> createCommission(@RequestBody Commission commission) {
        try {
            Commission createdCommission = commissionService.saveCommission(commission);
            return ResponseEntity.ok(createdCommission);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commission> updateCommission(@PathVariable Long id,
            @RequestBody Commission commissionDetails) {
        try {
            Optional<Commission> commissionOptional = commissionService.getCommissionById(id);
            if (commissionOptional.isPresent()) {
                Commission commission = commissionOptional.get();
                commission.setName(commissionDetails.getName());
                commission.setChargeDistribution(commissionDetails.getChargeDistribution());
                commission.setTotalValue(commissionDetails.getTotalValue());
                commission.setCompanyValue(commissionDetails.getCompanyValue());
                commission.setDebtorValue(commissionDetails.getDebtorValue());
                commission.setCreditorAccount(commissionDetails.getCreditorAccount());
                commission.setCompanyId(commissionDetails.getCompanyId());
                Commission updatedCommission = commissionService.saveCommission(commission);
                return ResponseEntity.ok(updatedCommission);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommission(@PathVariable Long id) {
        try {
            Optional<Commission> commissionOptional = commissionService.getCommissionById(id);
            if (commissionOptional.isPresent()) {
                commissionService.deleteCommission(id);
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
