package com.H8P190.beadando.hospital.dao;

import com.H8P190.beadando.hospital.entity.Medication;
import java.util.List;

public interface MedicationDAO {
    List<Medication> findAll();

    Medication findById(int id);

    Medication save(Medication medication);

    void deleteById(int id);
}

