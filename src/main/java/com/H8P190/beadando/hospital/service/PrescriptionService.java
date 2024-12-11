package com.H8P190.beadando.hospital.service;

import com.H8P190.beadando.hospital.entity.Prescription;
import java.util.List;

public interface PrescriptionService {
    List<Prescription> findAll();

    Prescription findById(int id);

    Prescription save(Prescription prescription);

    String deleteById(int id);
}
