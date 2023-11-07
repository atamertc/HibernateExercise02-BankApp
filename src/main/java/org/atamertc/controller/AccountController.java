package org.atamertc.controller;

import org.atamertc.repository.entity.Account;
import org.atamertc.service.AccountService;
import org.atamertc.service.CustomerService;

import java.util.List;

public class AccountController {
    private AccountService accountService;

    public AccountController() {
        this.accountService = new AccountService();
    }

    public List<Account> findByBalanceWithNamedQuery() {
        return accountService.findByBalanceWithNamedQuery();
    }

    public List<Account> findByCreatedDateWithNamedQuery() {
        return accountService.findByCreatedDateWithNamedQuery();
    }

    public double sumAccountOneBank(Long bankId) {
        return accountService.sumAccountOneBank(bankId);
    }

    public List<Account> findByCustomer(Long customerId) {
        return accountService.findByCustomer(customerId);
    }

}
