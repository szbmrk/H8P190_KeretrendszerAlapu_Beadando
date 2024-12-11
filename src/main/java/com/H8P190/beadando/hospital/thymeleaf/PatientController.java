package com.H8P190.beadando.hospital.thymeleaf;

import com.H8P190.beadando.hospital.entity.Patient;
import com.H8P190.beadando.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "patients";
    }

    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable int id, Model model) {
        model.addAttribute("patient", patientService.findById(id));
        return "edit-patient";
    }

    @PostMapping("/edit")
    public String updatePatient(Patient patient) {
        patientService.save(patient);
        return "redirect:/patients";
    }

    @PostMapping()
    public String addPatient(Patient patient) {
        patientService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }
}