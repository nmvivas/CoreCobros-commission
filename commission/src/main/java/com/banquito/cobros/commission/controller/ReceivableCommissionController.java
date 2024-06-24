package com.banquito.cobros.commission.controller;

import com.banquito.cobros.commission.dto.ReceivableCommissionDTO;
import com.banquito.cobros.commission.service.ReceivableCommissionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReceivableCommissionDTO>> getAllReceivableCommissions() {
        try {
            List<ReceivableCommissionDTO> receivableCommissions = receivableCommissionService
                    .getAllReceivableCommissions();
            return ResponseEntity.ok(receivableCommissions);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReceivableCommissionDTO> getReceivableCommissionById(@PathVariable Long id) {
        try {
            Optional<ReceivableCommissionDTO> receivableCommission = receivableCommissionService
                    .getReceivableCommissionById(id);
            return receivableCommission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/receivable/{receivableId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReceivableCommissionDTO>> getReceivableCommissionsByReceivableId(
            @PathVariable Long receivableId) {
        try {
            List<ReceivableCommissionDTO> receivableCommissions = receivableCommissionService
                    .getReceivableCommissionsByReceivableId(receivableId);
            return ResponseEntity.ok(receivableCommissions);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
