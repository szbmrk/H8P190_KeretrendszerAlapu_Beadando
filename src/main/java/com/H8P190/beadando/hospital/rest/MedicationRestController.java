package com.H8P190.beadando.hospital.rest;

import com.H8P190.beadando.hospital.entity.Medication;
import com.H8P190.beadando.hospital.entity.User;
import com.H8P190.beadando.hospital.service.MedicationService;
import com.H8P190.beadando.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationRestController {

    private MedicationService medicationService;
    private UserService userService;

    @Autowired
    public MedicationRestController(MedicationService medicationService, UserService userSerivce) {
        this.medicationService = medicationService;
        this.userService = userSerivce;
    }

    @GetMapping
    public List<Medication> findAll() {
        return medicationService.findAll();
    }

    @GetMapping("/forPharmacist/{id}")
    public List<Medication> findForPharmacist(@PathVariable int id)
    {
        User pharm = userService.findById(id);
        if (pharm.getRole() != User.Role.PHARMACIST){
            throw new IllegalArgumentException("Provided user id must belong to a pharmacist!");
        }

        return  medicationService.findForPharmacist(pharm);
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