package org.example.practica.controller;

import org.example.practica.model.Complaint;
import org.example.practica.repo.ComplaintRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintRepository complaintRepository;

    public ComplaintController(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @GetMapping
    public String getAllComplaints(Model model) {
        List<Complaint> complaints = complaintRepository.findAll();
        model.addAttribute("complaints", complaints);
        return "complaint/list";
    }

    @GetMapping("/{id}")
    public String getComplaintById(@PathVariable Long id, Model model) {
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        model.addAttribute("complaint", complaint);
        return "complaint/detail";
    }

    @GetMapping("/add")
    public String showAddComplaintForm(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "complaint/add";
    }

    @PostMapping("/add")
    public String addComplaint(@ModelAttribute Complaint complaint) {
        complaintRepository.save(complaint);
        return "redirect:/complaints";
    }

    @GetMapping("/edit/{id}")
    public String showEditComplaintForm(@PathVariable Long id, Model model) {
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        model.addAttribute("complaint", complaint);
        return "complaint/edit";
    }

    @PostMapping("/edit")
    public String editComplaint(@ModelAttribute Complaint complaint) {
        complaintRepository.save(complaint);
        return "redirect:/complaints";
    }

    @GetMapping("/delete/{id}")
    public String deleteComplaint(@PathVariable Long id) {
        complaintRepository.deleteById(id);
        return "redirect:/complaints";
    }
}
