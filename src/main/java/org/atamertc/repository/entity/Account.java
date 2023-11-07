package org.atamertc.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atamertc.repository.enums.EAccountType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedQueries({
        @NamedQuery(name = "Account.findByBalance", query = "select a from Account as a where a.balance>:mybalance"),
        @NamedQuery(name = "Account.findByCreatedDate", query = "select a from Account as a where a.createdDate<:mydate"),
        @NamedQuery(name = "Account.findByCustomer", query = "select a from Account as a where a.customer.id=:parameter")
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EAccountType eAccountType;
    @Builder.Default
    private String accountNumber = UUID.randomUUID().toString();
    @Builder.Default
    private LocalDate createdDate = LocalDate.now();
    private double balance;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Bank bank;
}
