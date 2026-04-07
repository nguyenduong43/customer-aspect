package org.example.customermanageaspect.controller;

import org.example.customermanageaspect.model.Customer;
import org.example.customermanageaspect.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    private final ICustomerService customerService;
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public String showList(Model model){
        try{
            List<Customer> customers=customerService.findAll();
            model.addAttribute("customers",customers);
            return "/customer/list";
        }catch (Exception e){
            return "/redirect:/customers";
        }
    }
    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable("id") Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/customer/info");
            Customer customer = customerService.findOne(id);
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }
}
