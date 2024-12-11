package com.H8P190.beadando.hospital.service.implementation;

import com.H8P190.beadando.hospital.dao.MedicationDAO;
import com.H8P190.beadando.hospital.entity.Medication;
import com.H8P190.beadando.hospital.service.MedicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {
    private MedicationDAO medicationDAO;

    public MedicationServiceImpl(MedicationDAO medicationDAO) {
        this.medicationDAO = medicationDAO;
    }

    @Override
    public List<Medication> findAll() {
        return medicationDAO.findAll();
    }

    @Override
    public Medication findById(int id) {
        return medicationDAO.findById(id);
    }

    @Override
    public Medication save(Medication medication) {
        return medicationDAO.save(medication);
    }

    @Override
    public String deleteById(int id) {
        Medication medication = medicationDAO.findById(id);

        if (medication != null) {
            medicationDAO.deleteById(id);
            return "Medication deleted successfully";
        }

        return "Medication not found";
    }
}