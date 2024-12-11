package com.H8P190.beadando.hospital.rest;

import com.H8P190.beadando.hospital.entity.Medication;
import com.H8P190.beadando.hospital.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationRestController {

    private MedicationService medicationService;

    @Autowired
    public MedicationRestController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping
    public List<Medication> findAll() {
        return medicationService.findAll();
    }

    @GetMapping("/{id}")
    public Medication findById(@PathVariable int id) {
        return medicationService.findById(id);
    }

    @PostMapping
    public Medication save(@RequestBody Medication medication) {
        return medicationService.save(medication);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        return medicationService.deleteById(id);
    }
}