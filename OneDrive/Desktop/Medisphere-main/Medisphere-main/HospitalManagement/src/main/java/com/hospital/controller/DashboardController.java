package com.hospital.controller;

import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.repository.AppointmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public DashboardController(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping
    public String dashboard(Model model) {
        // Get counts
        long totalDoctors = doctorRepository.count();
        long totalPatients = patientRepository.count();
        long totalAppointments = appointmentRepository.count();

        // Get all appointments
        var appointments = appointmentRepository.findAll();

        // Add attributes to model
        model.addAttribute("totalDoctors", totalDoctors);
        model.addAttribute("totalPatients", totalPatients);
        model.addAttribute("totalAppointments", totalAppointments);
        model.addAttribute("appointments", appointments);

        return "dashboard-stats";
    }
}
