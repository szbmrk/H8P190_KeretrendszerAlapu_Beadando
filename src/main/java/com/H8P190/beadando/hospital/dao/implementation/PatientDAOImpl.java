package com.H8P190.beadando.hospital.dao.implementation;

import com.H8P190.beadando.hospital.dao.PatientDAO;
import com.H8P190.beadando.hospital.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {
    private EntityManager entityManager;

    @Autowired
    public PatientDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Patient> findAll() {
        TypedQuery<Patient> query = entityManager.createQuery("FROM Patient", Patient.class);
        return query.getResultList();
    }

    @Override
    public Patient findById(int id) {
        return entityManager.find(Patient.class, id);
    }

    @Transactional
    @Override
    public Patient save(Patient patient) {
        return entityManager.merge(patient);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Patient patient = entityManager.find(Patient.class, id);
        if (patient != null) {
            entityManager.remove(patient);
        }
    }
}