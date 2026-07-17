package com.hospital.controller;

import com.hospital.model.Doctor;
import com.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("newDoctor", new Doctor());
        return "doctors";
    }

    @PostMapping("/add")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

    @PostMapping("/update/{id}")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setName(doctorDetails.getName());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
        return "redirect:/doctors";
    }
}