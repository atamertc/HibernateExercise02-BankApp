package org.atamertc.controller;

import org.atamertc.repository.entity.Bank;
import org.atamertc.service.BankService;

import java.util.List;

public class BankController {
    private BankService bankService;

    public BankController() {
        this.bankService = new BankService();
    }

    public Bank createBank(Bank bank) {
        return bankService.save(bank);
    }

    public List<Bank> findAll() {
        return bankService.findAll();
    }
}
