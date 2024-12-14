package com.H8P190.beadando.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "pharmacist_id", nullable = false)
    private User pharmacist;

    @Column(name = "prescribed_date")
    private LocalDateTime prescribedDate;

    public Medication() { this.prescribedDate = LocalDateTime.now(); }
    public Medication(Prescription prescription, String name, int quantity, User pharmacist) {
        this.prescription = prescription;
        this.name = name;
        this.quantity = quantity;
        this.prescribedDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(User pharmacist) {
        this.pharmacist = pharmacist;
    }

    public LocalDateTime getPrescribedDate() {
        return prescribedDate;
    }

    public void setPrescribedDate(LocalDateTime prescribedDate) {
        this.prescribedDate = prescribedDate;
    }
}
