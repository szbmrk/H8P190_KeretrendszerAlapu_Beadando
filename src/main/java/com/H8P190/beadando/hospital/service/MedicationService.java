package com.H8P190.beadando.hospital.service;

import com.H8P190.beadando.hospital.entity.Medication;
import java.util.List;

public interface MedicationService {
    List<Medication> findAll();

    Medication findById(int id);

    Medication save(Medication medication);

    String deleteById(int id);
}

