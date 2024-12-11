package com.H8P190.beadando.hospital.rest;

import com.H8P190.beadando.hospital.entity.Appointment;
import com.H8P190.beadando.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentRestController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment findById(@PathVariable int id) {
        return appointmentService.findById(id);
    }

    @PostMapping
    public Appointment save(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        return appointmentService.deleteById(id);
    }
}