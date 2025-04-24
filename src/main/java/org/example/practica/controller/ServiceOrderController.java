package org.example.practica.controller;

import org.example.practica.model.ServiceOrder;
import org.example.practica.repo.ServiceOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service-orders")
public class ServiceOrderController {

    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderController(ServiceOrderRepository serviceOrderRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
    }

    @GetMapping
    public String getAllServiceOrders(Model model) {
        List<ServiceOrder> serviceOrders = serviceOrderRepository.findAll();
        model.addAttribute("serviceOrders", serviceOrders);
        return "service-order/list";
    }

    @GetMapping("/{id}")
    public String getServiceOrderById(@PathVariable Long id, Model model) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id).orElse(null);
        model.addAttribute("serviceOrder", serviceOrder);
        return "service-order/detail";
    }

    @GetMapping("/add")
    public String showAddServiceOrderForm(Model model) {
        model.addAttribute("serviceOrder", new ServiceOrder());
        return "service-order/add";
    }

    @PostMapping("/add")
    public String addServiceOrder(@ModelAttribute ServiceOrder serviceOrder) {
        serviceOrderRepository.save(serviceOrder);
        return "redirect:/service-orders";
    }

    @GetMapping("/edit/{id}")
    public String showEditServiceOrderForm(@PathVariable Long id, Model model) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id).orElse(null);
        model.addAttribute("serviceOrder", serviceOrder);
        return "service-order/edit";
    }

    @PostMapping("/edit")
    public String editServiceOrder(@ModelAttribute ServiceOrder serviceOrder) {
        serviceOrderRepository.save(serviceOrder);
        return "redirect:/service-orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteServiceOrder(@PathVariable Long id) {
        serviceOrderRepository.deleteById(id);
        return "redirect:/service-orders";
    }
}
