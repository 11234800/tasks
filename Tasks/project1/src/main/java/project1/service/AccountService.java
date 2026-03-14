package project1.service;

import project1.models.Account;

public interface AccountService {
    Account createAccount(Account account);

    Account getAccountByNameAndPassword(Account account);

    Account deposite(Account account , double amount );

    Account withdraw(Account account , double amount );
}
