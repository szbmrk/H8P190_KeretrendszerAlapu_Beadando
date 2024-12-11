package com.H8P190.beadando.hospital.dao;

import com.H8P190.beadando.hospital.entity.Prescription;

import java.util.List;

public interface PrescriptionDAO {
    List<Prescription> findAll();

    Prescription findById(int id);

    Prescription save(Prescription prescription);

    void deleteById(int id);
}
