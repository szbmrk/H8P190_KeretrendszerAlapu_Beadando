package com.H8P190.beadando.hospital.service.implementation;

import com.H8P190.beadando.hospital.dao.PatientDAO;
import com.H8P190.beadando.hospital.entity.Patient;
import com.H8P190.beadando.hospital.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientDAO patientDAO;

    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public List<Patient> findAll() {
        return patientDAO.findAll();
    }

    @Override
    public Patient findById(int id) {
        return patientDAO.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientDAO.save(patient);
    }

    @Override
    public String deleteById(int id) {
        Patient patient = patientDAO.findById(id);

        if (patient != null) {
            patientDAO.deleteById(id);
            return "Patient deleted successfully";
        }

        return "Patient not found";
    }
}
