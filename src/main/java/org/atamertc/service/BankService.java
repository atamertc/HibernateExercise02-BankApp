package org.atamertc.service;

import org.atamertc.repository.BankRepository;
import org.atamertc.repository.entity.Bank;
import org.atamertc.utility.MyFactoryService;

public class BankService extends MyFactoryService<BankRepository, Bank, Long> {

    public BankService() {
        super(new BankRepository());
    }
}
