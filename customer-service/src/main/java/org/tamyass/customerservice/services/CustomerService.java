package org.tamyass.customerservice.services;

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
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer Not Found "));
    }
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }


}
