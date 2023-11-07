package org.atamertc;

import org.atamertc.controller.AccountController;
import org.atamertc.controller.BankController;
import org.atamertc.controller.CustomerController;
import org.atamertc.repository.BankRepository;
import org.atamertc.repository.entity.Account;
import org.atamertc.repository.entity.Bank;
import org.atamertc.repository.entity.Customer;
import org.atamertc.repository.enums.EAccountType;
import org.atamertc.utility.BankAppUtility;

import java.util.Arrays;
import java.util.List;

public class Main {
    static BankController bankController = new BankController();
    static CustomerController customerController = new CustomerController();
    static AccountController accountController = new AccountController();

    public static void main(String[] args) {
//        initializeBank();
//        menu();
//        accountController.findByBalanceWithNamedQuery().forEach(System.out::println);
//        accountController.findByCreatedDateWithNamedQuery().forEach(System.out::println);
//        System.out.println(accountController.sumAccountOneBank(1L));
//        System.out.println(accountController.findByCustomer(1L));
    }

    public static void initializeBank() {
        Bank bank = Bank.builder()
                .name("Garanti")
                .build();
        Bank bank2 = Bank.builder()
                .name("Ziraat")
                .build();
        bankController.createBank(bank);
        bankController.createBank(bank2);
    }

    public static void menu() {

        int choose = 0;
        do {
            System.out.println("1- Musteri Olustur");
            System.out.println("2- Giris Yap");
            System.out.println("0- Cikis Yap");
            choose = BankAppUtility.intVeriAlma("Lutfen bir secim yapiniz");
            switch (choose) {
                case 1 -> {
                    musteriOlustur();
                }
                case 2 -> {

                }
                case 0 -> {
                    System.out.println("Cikis yapildi");
                }
            }
        } while (choose != 0);
    }

    private static void musteriOlustur() {
        List<Bank> banks = bankController.findAll();
        banks.forEach(x -> System.out.println(x.getId() + "-" + x.getName()));
        Long bankId = BankAppUtility.longVeriAlma("Lutfen bir Banka ID giriniz: ");
        Bank bank = banks.stream().filter(x->x.getId()==bankId).findFirst().get();
        Account account = hesapOlustur();
        Customer customer = Customer.builder()
                .name(BankAppUtility.stringVeriAlma("Musteri ismini giriniz: "))
                .username(BankAppUtility.stringVeriAlma("Musteri kullanici adi giriniz: "))
                .password(BankAppUtility.stringVeriAlma("Musteri sifresini giriniz: "))
                .banks(List.of(bank))
                .accounts(List.of(account))
                .build();
        account.setCustomer(customer);
        account.setBank(bank);
        customerController.createCustomer(customer);
    }

    private static Account hesapOlustur() {
        EAccountType[] accountTypes = EAccountType.values();
        for (EAccountType type : accountTypes) {
            System.out.println((type.ordinal() + 1) + "-" + type.name());
        }
        int index = BankAppUtility.intVeriAlma("Lutfen bir hesap turu seciniz")-1;
        EAccountType accountType = accountTypes[index];
        Account account = Account.builder()
                .eAccountType(accountType)
                .build();
        return account;
    }

}