package com.H8P190.beadando.hospital.dao.implementation;

import com.H8P190.beadando.hospital.dao.PrescriptionDAO;
import com.H8P190.beadando.hospital.entity.Prescription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDAOImpl implements PrescriptionDAO {
    private EntityManager entityManager;

    @Autowired
    public PrescriptionDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Prescription> findAll() {
        TypedQuery<Prescription> query = entityManager.createQuery("FROM Prescription", Prescription.class);
        return query.getResultList();
    }

    @Override
    public Prescription findById(int id) {
        return entityManager.find(Prescription.class, id);
    }

    @Transactional
    @Override
    public Prescription save(Prescription prescription) {
        return entityManager.merge(prescription);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Prescription prescription = entityManager.find(Prescription.class, id);
        if (prescription != null) {
            entityManager.remove(prescription);
        }
    }
}
