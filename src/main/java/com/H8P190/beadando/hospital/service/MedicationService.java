package com.H8P190.beadando.hospital.service;

import com.H8P190.beadando.hospital.entity.Medication;
import com.H8P190.beadando.hospital.entity.User;

import java.util.List;

public interface MedicationService {
    List<Medication> findAll();

    Medication findById(int id);

    List<Medication> findForPharmacist(User pharm);

    Medication save(Medication medication);

    String deleteById(int id);
}

