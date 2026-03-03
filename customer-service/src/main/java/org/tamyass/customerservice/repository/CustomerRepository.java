package org.tamyass.customerservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tamyass.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
