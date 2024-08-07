package com.banquito.cobros.commission.controller;

import com.banquito.cobros.commission.model.PayCommRecord;
import com.banquito.cobros.commission.service.PayCommRecordService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("/paycommrecords")
public class PayCommRecordController {

    private final PayCommRecordService payCommRecordService;

    public PayCommRecordController(PayCommRecordService payCommRecordService) {
        this.payCommRecordService = payCommRecordService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PayCommRecord>> getAllPayCommRecords() {
        try {
            List<PayCommRecord> payCommRecords = payCommRecordService.getAllPayCommRecords();
            return ResponseEntity.ok(payCommRecords);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayCommRecord> getPayCommRecordById(@PathVariable Long id) {
        try {
            Optional<PayCommRecord> payCommRecord = payCommRecordService.getPayCommRecordById(id);
            return payCommRecord.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayCommRecord> createPayCommRecord(@RequestBody PayCommRecord payCommRecord) {
        try {
            PayCommRecord createdPayCommRecord = payCommRecordService.savePayCommRecord(payCommRecord);
            return ResponseEntity.ok(createdPayCommRecord);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayCommRecord> updatePayCommRecord(@PathVariable Long id,
            @RequestBody PayCommRecord payCommRecordDetails) {
        try {
            Optional<PayCommRecord> payCommRecordOptional = payCommRecordService.getPayCommRecordById(id);
            if (payCommRecordOptional.isPresent()) {
                PayCommRecord payCommRecord = payCommRecordOptional.get();
                payCommRecord.setCommissionId(payCommRecordDetails.getCommissionId());
                payCommRecord.setPaymentRecordId(payCommRecordDetails.getPaymentRecordId());
                payCommRecord.setNote(payCommRecordDetails.getNote());
                PayCommRecord updatedPayCommRecord = payCommRecordService.savePayCommRecord(payCommRecord);
                return ResponseEntity.ok(updatedPayCommRecord);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
