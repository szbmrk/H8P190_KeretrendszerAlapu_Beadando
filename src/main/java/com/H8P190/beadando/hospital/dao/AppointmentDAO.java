package com.H8P190.beadando.hospital.dao;

import com.H8P190.beadando.hospital.entity.Appointment;
import java.util.List;

public interface AppointmentDAO {
    List<Appointment> findAll();

    Appointment findById(int id);

    Appointment save(Appointment appointment);

    void deleteById(int id);
}
