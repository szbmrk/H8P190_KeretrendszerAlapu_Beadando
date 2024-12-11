package com.H8P190.beadando.hospital.thymeleaf;

import com.H8P190.beadando.hospital.entity.Prescription;
import com.H8P190.beadando.hospital.entity.Appointment;
import com.H8P190.beadando.hospital.entity.Patient;
import com.H8P190.beadando.hospital.entity.User;
import com.H8P190.beadando.hospital.service.PrescriptionService;
import com.H8P190.beadando.hospital.service.AppointmentService;
import com.H8P190.beadando.hospital.service.PatientService;
import com.H8P190.beadando.hospital.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final AppointmentService appointmentService;

    public PrescriptionController(PrescriptionService prescriptionService, AppointmentService appointmentService) {
        this.prescriptionService = prescriptionService;
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String listPrescriptions(Model model) {
        model.addAttribute("prescriptions", prescriptionService.findAll());
        model.addAttribute("appointments", appointmentService.findAll());
        return "prescriptions";
    }

    @GetMapping("/edit/{id}")
    public String editPrescription(@PathVariable int id, Model model) {
        model.addAttribute("prescription", prescriptionService.findById(id));
        model.addAttribute("appointments", appointmentService.findAll());
        return "edit-prescription";
    }

    @PostMapping("/edit")
    public String updatePrescription(@ModelAttribute Prescription prescription,
                                     @RequestParam("appointmentId") int appointmentId) {
        Appointment appointment = appointmentService.findById(appointmentId);

        prescription.setAppointment(appointment);

        prescriptionService.save(prescription);
        return "redirect:/prescriptions";
    }

    @PostMapping
    public String addPrescription(@ModelAttribute Prescription prescription,
                                  @RequestParam("appointmentId") int appointmentId) {
        Appointment appointment = appointmentService.findById(appointmentId);

        prescription.setAppointment(appointment);

        prescriptionService.save(prescription);
        return "redirect:/prescriptions";
    }

    @GetMapping("/delete/{id}")
    public String deletePrescription(@PathVariable int id) {
        prescriptionService.deleteById(id);
        return "redirect:/prescriptions";
    }
}