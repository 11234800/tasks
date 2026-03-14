package project1.service.impl;

import project1.models.Account;
import project1.service.AccountService;
import project1.service.ApplicationService;

import java.util.Objects;
import java.util.Scanner;

public class  ApplicationServiceImpl implements ApplicationService {
    private AccountService accountService = new AccountServiceImpl();
    @Override
    public void startApplication() {
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.println("1.login     2.signup    3.exit");
            System.out.println("please enter your choose");
            int choice = sc.nextInt();
            boolean isExit = false;
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("have a nice day");
                    isExit = true;
                    break;
                default:
                    System.out.println("invalid choice");
                    counter++;
            }

            if (isExit)
                break;

            if (counter == 4) {
                System.out.println("many times failed choice please contact with admin");
                break;
            }
        }
    }
    private void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your username");
        String userName = sc.nextLine();
        System.out.println("please enter your password");
        String password = sc.nextLine();

        Account account = new Account(userName, password);
        Account accountLogin = accountService.getAccountByNameAndPassword(account);

        if (Objects.nonNull(accountLogin)) {
            System.out.println("login success");
            showProfile(accountLogin);
        }
        else {
            System.out.println("invalid username or password");
        }
    }
    private void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your name");
        String userName = sc.nextLine();

        System.out.println("please enter your password");
        String password = sc.nextLine();

        System.out.println("please enter your age");
        float age = sc.nextFloat();

        System.out.println("please enter your phone number");
        String phoneNumber = sc.nextLine();

        Account account = new Account(userName, password, age, phoneNumber);

        Account isAccountCreated = accountService.createAccount(account);
        if (Objects.nonNull(isAccountCreated)) {
            System.out.println("Account created successfully");
            showProfile(isAccountCreated);
        }
        else {
            System.out.println("username already exists");
        }
    }

    private void showProfile(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.deposit 2.withdraw 3.showBalance 4.logout");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                deposit(account);
                break;
            case 2:
                break;
            default:
        }
    }
    private void deposit(Account account) {
        System.out.println("your details is...");
        System.out.println("username is " + account.getUsername());
        System.out.println("password is " + account.getPassword());
        System.out.println("age is " + account.getAge());
        System.out.println("phone number is " + account.getPhoneNumber());
        System.out.println("balance is " + account.getBalance());

        System.out.println("please enter the amount you want to deposit");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        Account accountDepositSuccess = accountService.deposite(account, amount);
        if (Objects.nonNull(accountDepositSuccess)) {
            System.out.println("deposited successfully and current balance is " + accountDepositSuccess.getBalance());
        }
        else {
            System.out.println("deposited failed");
        }
    }
}
