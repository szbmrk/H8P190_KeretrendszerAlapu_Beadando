package com.H8P190.beadando.hospital.dao;

import com.H8P190.beadando.hospital.entity.Medication;
import com.H8P190.beadando.hospital.entity.User;

import java.util.List;

public interface MedicationDAO {
    List<Medication> findAll();

    Medication findById(int id);

    List<Medication> findForPharmacist(User pharm);

    Medication save(Medication medication);

    void deleteById(int id);
}

