package org.atamertc.repository;

import org.atamertc.repository.entity.Bank;
import org.atamertc.utility.MyFactoryRepository;
import javax.persistence.TypedQuery;
import java.util.Collection;


public class BankRepository extends MyFactoryRepository<Bank, Long> {

    public BankRepository() {
        super(new Bank());
    }
}
