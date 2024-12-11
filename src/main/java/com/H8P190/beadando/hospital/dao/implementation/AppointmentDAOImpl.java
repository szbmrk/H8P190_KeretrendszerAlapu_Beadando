package com.H8P190.beadando.hospital.dao.implementation;

import com.H8P190.beadando.hospital.dao.AppointmentDAO;
import com.H8P190.beadando.hospital.entity.Appointment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {
    private EntityManager entityManager;

    @Autowired
    public AppointmentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Appointment> findAll() {
        TypedQuery<Appointment> query = entityManager.createQuery("FROM Appointment", Appointment.class);
        return query.getResultList();
    }

    @Override
    public Appointment findById(int id) {
        return entityManager.find(Appointment.class, id);
    }

    @Transactional
    @Override
    public Appointment save(Appointment appointment) {
        return entityManager.merge(appointment);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        if (appointment != null) {
            entityManager.remove(appointment);
        }
    }
}

