package com.hospital.controller;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("newPatient", new Patient());
        return "patients";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @PostMapping("/update/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute Patient patientDetails) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setName(patientDetails.getName());
        patient.setEmail(patientDetails.getEmail());
        patient.setPhone(patientDetails.getPhone());
        patient.setIllness(patientDetails.getIllness());
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
}