package com.H8P190.beadando.hospital.dao;

import com.H8P190.beadando.hospital.entity.Patient;
import java.util.List;

public interface PatientDAO {
    List<Patient> findAll();

    Patient findById(int id);

    Patient save(Patient patient);

    void deleteById(int id);
}

