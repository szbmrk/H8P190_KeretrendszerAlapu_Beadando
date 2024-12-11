package com.H8P190.beadando.hospital.dao.implementation;

import com.H8P190.beadando.hospital.dao.MedicationDAO;
import com.H8P190.beadando.hospital.entity.Medication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicationDAOImpl implements MedicationDAO {
    private EntityManager entityManager;

    @Autowired
    public MedicationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Medication> findAll() {
        TypedQuery<Medication> query = entityManager.createQuery("FROM Medication", Medication.class);
        return query.getResultList();
    }

    @Override
    public Medication findById(int id) {
        return entityManager.find(Medication.class, id);
    }

    @Transactional
    @Override
    public Medication save(Medication medication) {
        return entityManager.merge(medication);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Medication medication = entityManager.find(Medication.class, id);
        if (medication != null) {
            entityManager.remove(medication);
        }
    }
}
