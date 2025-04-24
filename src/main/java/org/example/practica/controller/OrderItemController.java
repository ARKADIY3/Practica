package org.example.practica.controller;

import org.example.practica.model.OrderItem;
import org.example.practica.repo.OrderItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemRepository orderItemRepository;

    public OrderItemController(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @GetMapping
    public String getAllOrderItems(Model model) {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        model.addAttribute("orderItems", orderItems);
        return "order-item/list";
    }

    @GetMapping("/{id}")
    public String getOrderItemById(@PathVariable Long id, Model model) {
        OrderItem orderItem = orderItemRepository.findById(id).orElse(null);
        model.addAttribute("orderItem", orderItem);
        return "order-item/detail";
    }

    @GetMapping("/add")
    public String showAddOrderItemForm(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        return "order-item/add";
    }

    @PostMapping("/add")
    public String addOrderItem(@ModelAttribute OrderItem orderItem) {
        orderItemRepository.save(orderItem);
        return "redirect:/order-items";
    }

    @GetMapping("/edit/{id}")
    public String showEditOrderItemForm(@PathVariable Long id, Model model) {
        OrderItem orderItem = orderItemRepository.findById(id).orElse(null);
        model.addAttribute("orderItem", orderItem);
        return "order-item/edit";
    }

    @PostMapping("/edit")
    public String editOrderItem(@ModelAttribute OrderItem orderItem) {
        orderItemRepository.save(orderItem);
        return "redirect:/order-items";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id) {
        orderItemRepository.deleteById(id);
        return "redirect:/order-items";
    }
}
