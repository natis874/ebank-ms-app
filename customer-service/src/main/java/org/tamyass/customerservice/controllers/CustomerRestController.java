package org.tamyass.customerservice.controllers;

import org.springframework.web.bind.annotation.*;
import org.tamyass.customerservice.entities.Customer;
import org.tamyass.customerservice.services.CustomerService;

import java.util.List;
@CrossOrigin("*")
@RestController
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

}
