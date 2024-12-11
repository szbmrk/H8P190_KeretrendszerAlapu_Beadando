package com.H8P190.beadando.hospital.service.implementation;

import com.H8P190.beadando.hospital.dao.PrescriptionDAO;
import com.H8P190.beadando.hospital.entity.Prescription;
import com.H8P190.beadando.hospital.service.PrescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    private PrescriptionDAO prescriptionDAO;

    public PrescriptionServiceImpl(PrescriptionDAO prescriptionDAO) {
        this.prescriptionDAO = prescriptionDAO;
    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionDAO.findAll();
    }

    @Override
    public Prescription findById(int id) {
        return prescriptionDAO.findById(id);
    }

    @Override
    public Prescription save(Prescription prescription) {
        return prescriptionDAO.save(prescription);
    }

    @Override
    public String deleteById(int id) {
        Prescription prescription = prescriptionDAO.findById(id);

        if (prescription != null) {
            prescriptionDAO.deleteById(id);
            return "Prescription deleted successfully";
        }

        return "Prescription not found";
    }
}

