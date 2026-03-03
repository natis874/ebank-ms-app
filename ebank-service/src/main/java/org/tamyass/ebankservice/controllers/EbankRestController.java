package org.tamyass.ebankservice.controllers;

import org.springframework.web.bind.annotation.*;
import org.tamyass.ebankservice.entities.BankAccount;
import org.tamyass.ebankservice.services.EBankService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@CrossOrigin("*")
@RestController
public class EbankRestController {
    private EBankService ebankService;

    public EbankRestController(EBankService ebankService) {
        this.ebankService = ebankService;
    }
    @GetMapping("/accounts")
    public List<BankAccount> gettAllBankAccounts(){
        return ebankService.gettAllBankAccounts();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id){
        return ebankService.getBankAccountById(id);
    }
    @PostMapping("/accounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        return ebankService.save(bankAccount);
    }
}
