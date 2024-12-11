package com.H8P190.beadando.hospital.service;

import com.H8P190.beadando.hospital.entity.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> findAll();

    Patient findById(int id);

    Patient save(Patient patient);

    String deleteById(int id);
}