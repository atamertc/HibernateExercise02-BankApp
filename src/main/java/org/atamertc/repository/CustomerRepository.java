package org.atamertc.repository;

import org.atamertc.repository.entity.Bank;
import org.atamertc.repository.entity.Customer;
import org.atamertc.utility.MyFactoryRepository;

public class CustomerRepository extends MyFactoryRepository<Customer, Long> {

    public CustomerRepository() {
        super(new Customer());
    }
}
