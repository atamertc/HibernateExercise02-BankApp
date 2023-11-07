package org.atamertc.service;

import org.atamertc.repository.AccountRepository;
import org.atamertc.repository.CustomerRepository;
import org.atamertc.repository.entity.Account;
import org.atamertc.repository.entity.Customer;
import org.atamertc.utility.MyFactoryService;

public class CustomerService extends MyFactoryService<CustomerRepository, Customer, Long> {

    public CustomerService() {
        super(new CustomerRepository());
    }
}
