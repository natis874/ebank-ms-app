package org.tamyass.ebankservice.services;

import org.springframework.stereotype.Service;
import org.tamyass.ebankservice.entities.BankAccount;
import org.tamyass.ebankservice.feign.CustomerRestClient;
import org.tamyass.ebankservice.models.Customer;
import org.tamyass.ebankservice.repository.BankAccountRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EBankService {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public EBankService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> gettAllBankAccounts(){
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(String id){
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account Not Found "));
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }
    public BankAccount save(BankAccount bankAccount){
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return bankAccountRepository.save(bankAccount);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
