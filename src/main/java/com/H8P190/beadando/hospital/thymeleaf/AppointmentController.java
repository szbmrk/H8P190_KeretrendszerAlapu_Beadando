package com.H8P190.beadando.hospital.thymeleaf;

import com.H8P190.beadando.hospital.entity.Appointment;
import com.H8P190.beadando.hospital.entity.Patient;
import com.H8P190.beadando.hospital.entity.User;
import com.H8P190.beadando.hospital.service.AppointmentService;
import com.H8P190.beadando.hospital.service.PatientService;
import com.H8P190.beadando.hospital.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final UserService userService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService, UserService userService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.userService = userService;
    }

    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("doctors", userService.findAllDoctors());
        model.addAttribute("page", "appointments");
        return "appointments";
    }

    @GetMapping("/edit/{id}")
    public String editAppointment(@PathVariable int id, Model model) {
        model.addAttribute("appointment", appointmentService.findById(id));
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("doctors", userService.findAllDoctors());
        model.addAttribute("page", "appointments");
        return "edit-appointment";
    }

    @PostMapping("/edit")
    public String updateAppointment(@ModelAttribute Appointment appointment,
                                    @RequestParam("patientId") int patientId,
                                    @RequestParam("doctorId") int doctorId) {
        Patient patient = patientService.findById(patientId);
        User doctor = userService.findById(doctorId);

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentService.save(appointment);
        return "redirect:/appointments";
    }

    @PostMapping
    public String addAppointment(@ModelAttribute Appointment appointment,
                                 @RequestParam("patientId") int patientId,
                                 @RequestParam("doctorId") int doctorId) {
        Patient patient = patientService.findById(patientId);
        User doctor = userService.findById(doctorId);

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentService.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable int id) {
        appointmentService.deleteById(id);
        return "redirect:/appointments";
    }
}
