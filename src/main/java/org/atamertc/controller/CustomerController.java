package org.atamertc.controller;

import org.atamertc.repository.entity.Bank;
import org.atamertc.repository.entity.Customer;
import org.atamertc.service.BankService;
import org.atamertc.service.CustomerService;

public class CustomerController {
    private CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public Customer createCustomer(Customer customer) {
        return customerService.save(customer);
    }

}
