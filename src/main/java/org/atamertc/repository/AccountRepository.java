package org.atamertc.repository;

import org.atamertc.repository.entity.Account;
import org.atamertc.repository.entity.Customer;
import org.atamertc.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class AccountRepository extends MyFactoryRepository<Account, Long> {

    public AccountRepository() {
        super(new Account());
    }

    public List<Account> findByBalanceWithNamedQuery() {
        TypedQuery<Account> typedQuery = getEntityManager().createNamedQuery("Account.findByBalance", Account.class);
        typedQuery.setParameter("mybalance", 5000D);
        return typedQuery.getResultList();
    }

    public List<Account> findByCreatedDateWithNamedQuery() {
        TypedQuery<Account> typedQuery = getEntityManager().createNamedQuery("Account.findByCreatedDate", Account.class);
        typedQuery.setParameter("mydate", LocalDate.parse("2023-07-05"));
        return typedQuery.getResultList();
    }

    public double sumAccountOneBank(Long bankId) {
        CriteriaQuery<Double> criteriaQuery = getCriteriaBuilder().createQuery(Double.class);
        Root<Account> root = criteriaQuery.from(Account.class);
        criteriaQuery.select(getCriteriaBuilder().sum(root.get("balance")))
                .where(getCriteriaBuilder().equal(root.get("bank").get("id"), bankId));
        return getEntityManager().createQuery(criteriaQuery).getSingleResult();
    }

    public List<Account> findByCustomer(Long customerId) {
        TypedQuery<Account> typedQuery = getEntityManager().createNamedQuery("Account.findByCustomer", Account.class);
        typedQuery.setParameter("parameter", customerId);
        return typedQuery.getResultList();
    }


}
