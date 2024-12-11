package com.H8P190.beadando.hospital.service.implementation;

import com.H8P190.beadando.hospital.dao.AppointmentDAO;
import com.H8P190.beadando.hospital.entity.Appointment;
import com.H8P190.beadando.hospital.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentDAO.findAll();
    }

    @Override
    public Appointment findById(int id) {
        return appointmentDAO.findById(id);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentDAO.save(appointment);
    }

    @Override
    public String deleteById(int id) {
        Appointment appointment = appointmentDAO.findById(id);

        if (appointment != null) {
            appointmentDAO.deleteById(id);
            return "Appointment deleted successfully";
        }

        return "Appointment not found";
    }
}

