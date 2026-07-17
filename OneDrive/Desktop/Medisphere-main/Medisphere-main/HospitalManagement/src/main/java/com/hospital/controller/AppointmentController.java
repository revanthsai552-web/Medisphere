package com.hospital.controller;

import com.hospital.model.Appointment;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentController(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public String viewAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("newAppointment", new Appointment());
        return "appointments";
    }

    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute Appointment appointment) {
        appointment.setStatus("BOOKED");
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @PostMapping("/update-status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        Appointment app = appointmentRepository.findById(id).orElseThrow();
        app.setStatus(status);
        appointmentRepository.save(app);
        return "redirect:/appointments";
    }

    @GetMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        Appointment app = appointmentRepository.findById(id).orElseThrow();
        app.setStatus("CANCELLED");
        appointmentRepository.save(app);
        return "redirect:/appointments";
    }
}