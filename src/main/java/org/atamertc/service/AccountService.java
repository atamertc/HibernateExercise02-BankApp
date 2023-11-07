package org.atamertc.service;

import org.atamertc.repository.AccountRepository;
import org.atamertc.repository.BankRepository;
import org.atamertc.repository.entity.Account;
import org.atamertc.repository.entity.Bank;
import org.atamertc.utility.MyFactoryService;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountService extends MyFactoryService<AccountRepository, Account, Long> {

    public AccountService() {
        super(new AccountRepository());
    }

    public List<Account> findByBalanceWithNamedQuery() {
        return getRepository().findByBalanceWithNamedQuery();
    }

    public List<Account> findByCreatedDateWithNamedQuery() {
        return getRepository().findByCreatedDateWithNamedQuery();
    }

    public double sumAccountOneBank(Long bankId) {
        return getRepository().sumAccountOneBank(bankId);
    }

    public List<Account> findByCustomer(Long customerId) {
        return getRepository().findByCustomer(customerId);
    }

}
