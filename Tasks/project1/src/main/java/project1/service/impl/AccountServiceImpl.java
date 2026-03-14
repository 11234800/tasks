package project1.service.impl;

import project1.models.Account;
import project1.models.EWalletSystem;
import project1.service.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private EWalletSystem eWalletSystem = new EWalletSystem();

    @Override
    public Account createAccount(Account account) {
        List<Account> accounts = eWalletSystem.getAccounts();
        Optional<Account> optionalAccount= accounts.stream().filter(acc->acc.getUsername().equals(account.getUsername())).findAny();
        if(optionalAccount.isPresent()){
            return null;
        }
        eWalletSystem.getAccounts().add(account);
        return account;
    }

    @Override
    public Account getAccountByNameAndPassword(Account account) {
        List<Account> accounts = eWalletSystem.getAccounts();
        Optional<Account> optionalAccount= accounts.stream().filter(acc->acc.getUsername()
                .equals(account.getUsername())&&acc.getPassword().equals(account.getPassword())).findAny();
        if(optionalAccount.isPresent()) {
            return optionalAccount.get();
        }
            return null;
    }

    @Override
    public Account deposite(Account account, double amount) {
        List<Account> accounts = eWalletSystem.getAccounts();
        Optional<Account> optionalAccount= accounts.stream().filter(acc->acc.getUsername()
                .equals(account.getUsername())&&acc.getPassword().equals(account.getPassword())).findAny();
        if(optionalAccount.isEmpty()) {
            return null;
        }

        if(amount < 100) {
            return null;
        }

        Account accountDeposit = optionalAccount.get();
        accountDeposit.setBalance(accountDeposit.getBalance() + amount);
        return accountDeposit;
    }
}
