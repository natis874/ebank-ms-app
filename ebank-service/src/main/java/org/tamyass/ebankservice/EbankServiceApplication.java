package org.tamyass.ebankservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.tamyass.ebankservice.entities.BankAccount;
import org.tamyass.ebankservice.services.EBankService;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EBankService eBankService) {
        return args -> {
            for (int i = 1; i <= 3; i++) {
                for (int j= 1;j<5;j++){
                    eBankService.save(BankAccount.builder()
                                    .type(Math.random()>0.5?" CURRENT-ACCOUNT":"SAVING-ACCOUNT")
                                    .balance(1000+Math.random()*60000)
                                    .customerId(i)
                            .build());
                }
            }

        };
    }
}
