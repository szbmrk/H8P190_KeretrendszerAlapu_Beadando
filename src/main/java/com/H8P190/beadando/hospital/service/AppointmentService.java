package com.H8P190.beadando.hospital.service;

import com.H8P190.beadando.hospital.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();

    Appointment findById(int id);

    Appointment save(Appointment appointment);

    String deleteById(int id);
}

