package org.tamyass.customerservice.services;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;
import org.tamyass.customerservice.entities.Customer;
import org.tamyass.customerservice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @McpTool(description = "Get All Customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @McpTool(description = "Find a Customer by od")
    public Customer findCustomerById(@McpToolParam(description = "The customer id") Long id){
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer Not Found "));
    }
    @McpTool(description = "Save a new Customer")
    public Customer saveCustomer(@McpToolParam(description = "The Customer to save(name,email)") Customer customer){
        return customerRepository.save(customer);
    }


}
