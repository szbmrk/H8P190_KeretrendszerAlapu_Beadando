package com.H8P190.beadando.hospital.rest;

import com.H8P190.beadando.hospital.entity.Prescription;
import com.H8P190.beadando.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionRestController {

    private PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionRestController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public List<Prescription> findAll() {
        return prescriptionService.findAll();
    }

    @GetMapping("/{id}")
    public Prescription findById(@PathVariable int id) {
        return prescriptionService.findById(id);
    }

    @PostMapping
    public Prescription save(@RequestBody Prescription prescription) {
        return prescriptionService.save(prescription);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        return prescriptionService.deleteById(id);
    }
}