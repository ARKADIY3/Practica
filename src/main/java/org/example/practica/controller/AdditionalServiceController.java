package org.example.practica.controller;

import org.example.practica.model.AdditionalService;
import org.example.practica.repo.AdditionalServiceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/additional-services")
public class AdditionalServiceController {

    private final AdditionalServiceRepository additionalServiceRepository;

    public AdditionalServiceController(AdditionalServiceRepository additionalServiceRepository) {
        this.additionalServiceRepository = additionalServiceRepository;
    }

    @GetMapping
    public String getAllAdditionalServices(Model model) {
        List<AdditionalService> services = additionalServiceRepository.findAll();
        model.addAttribute("services", services);
        return "additional-service/list";
    }

    @GetMapping("/{id}")
    public String getAdditionalServiceById(@PathVariable Long id, Model model) {
        AdditionalService service = additionalServiceRepository.findById(id).orElse(null);
        model.addAttribute("service", service);
        return "additional-service/detail";
    }

    @GetMapping("/add")
    public String showAddAdditionalServiceForm(Model model) {
        model.addAttribute("service", new AdditionalService());
        return "additional-service/add";
    }

    @PostMapping("/add")
    public String addAdditionalService(@ModelAttribute AdditionalService service) {
        additionalServiceRepository.save(service);
        return "redirect:/additional-services";
    }

    @GetMapping("/edit/{id}")
    public String showEditAdditionalServiceForm(@PathVariable Long id, Model model) {
        AdditionalService service = additionalServiceRepository.findById(id).orElse(null);
        model.addAttribute("service", service);
        return "additional-service/edit";
    }

    @PostMapping("/edit")
    public String editAdditionalService(@ModelAttribute AdditionalService service) {
        additionalServiceRepository.save(service);
        return "redirect:/additional-services";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdditionalService(@PathVariable Long id) {
        additionalServiceRepository.deleteById(id);
        return "redirect:/additional-services";
    }
}
