package com.H8P190.beadando.hospital.thymeleaf;

import com.H8P190.beadando.hospital.entity.Medication;
import com.H8P190.beadando.hospital.entity.Prescription;
import com.H8P190.beadando.hospital.entity.User;
import com.H8P190.beadando.hospital.service.MedicationService;
import com.H8P190.beadando.hospital.service.PrescriptionService;
import com.H8P190.beadando.hospital.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medications")
public class MedicationController {
    private final MedicationService medicationService;
    private final PrescriptionService prescriptionService;
    private final UserService userService;

    public MedicationController(MedicationService medicationService, PrescriptionService prescriptionService, UserService userService) {
        this.medicationService = medicationService;
        this.prescriptionService = prescriptionService;
        this.userService = userService;
    }

    @GetMapping
    public String listMedications(Model model) {
        model.addAttribute("medications", medicationService.findAll());
        model.addAttribute("prescriptions", prescriptionService.findAll());
        model.addAttribute("pharmacists", userService.findAllPharmacists());
        model.addAttribute("page", "medications");
        return "medications";
    }

    @GetMapping("/edit/{id}")
    public String editMedication(@PathVariable int id, Model model) {
        model.addAttribute("medication", medicationService.findById(id));
        model.addAttribute("prescriptions", prescriptionService.findAll());
        model.addAttribute("pharmacists", userService.findAllPharmacists());
        model.addAttribute("page", "medications");
        return "edit-medication";
    }

    @PostMapping("/edit")
    public String updateMedication(@ModelAttribute Medication medication,
                                   @RequestParam("prescriptionId") int prescriptionId,
                                   @RequestParam("pharmacistId") int pharmacistId) {
        Prescription prescription = prescriptionService.findById(prescriptionId);
        User pharmacist = userService.findById(pharmacistId);

        medication.setPrescription(prescription);
        medication.setPharmacist(pharmacist);

        medicationService.save(medication);
        return "redirect:/medications";
    }

    @PostMapping
    public String addMedication(@ModelAttribute Medication medication,
                                @RequestParam("prescriptionId") int prescriptionId,
                                @RequestParam("pharmacistId") int pharmacistId) {
        Prescription prescription = prescriptionService.findById(prescriptionId);
        User pharmacist = userService.findById(pharmacistId);

        medication.setPrescription(prescription);
        medication.setPharmacist(pharmacist);

        medicationService.save(medication);
        return "redirect:/medications";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedication(@PathVariable int id) {
        medicationService.deleteById(id);
        return "redirect:/medications";
    }
}