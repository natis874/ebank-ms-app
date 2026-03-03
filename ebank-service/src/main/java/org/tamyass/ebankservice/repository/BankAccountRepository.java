package org.tamyass.ebankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamyass.ebankservice.entities.BankAccount;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    List<BankAccount> findByCustomerId(Long id);
}
