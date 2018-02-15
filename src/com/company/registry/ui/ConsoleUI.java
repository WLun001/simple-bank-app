package com.company.registry.ui;

import com.company.registry.domain.Account;
import com.company.registry.domain.Controller;
import com.company.registry.domain.IAccountRegistry;
import com.company.registry.domain.IAccountRegistry.AccountType;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.registry.domain.IAccountRegistry.AccountType.CHECKING;
import static com.company.registry.domain.IAccountRegistry.AccountType.SAVING;

public class ConsoleUI implements IUserInterface {

    private Controller controller;
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("Do you want to:");
            System.out.println("1. Display all accounts");
            System.out.println("2 - Create an account");
            System.out.println("3 - Search account by name");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();
            while (choice < 1 || choice > 4) {
                System.out.println("Invalid choice.");
                System.out.print("Enter your choice (1-4): ");
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1:
                    displayAccount();
                    break;
                case 2:
                    addAccount();
                    break;
                case 3:
                    searchAccount();
                    break;
            }

            System.out.println();

        } while (choice != 4);
    }
    private  void displayAccount() {
        System.out.print("List account by: (0 - All, 1 - Saving , 2 - Checking): ");
        int choice = scanner.nextInt();

        if (controller.getNumberofAccounts() > 0) {
            ArrayList<Account> accountList;
            if (choice != 0) {
                AccountType type = choice == 1 ? SAVING : CHECKING;
                accountList = controller.getAccounts(type);
            } else accountList = controller.getAccounts();


            for (Account account : accountList) {
                printAccountDetails(account);
            }
        } else {
            System.out.println("No accounts found, please add account to get started");
        }

    }

    private  void addAccount() {
        System.out.print("Enter account holder name: ");
        // clear previous input before input name
        String skip = scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter account type: (0 - Saving, 1 - Checking): ");
        int type = scanner.nextInt();
        AccountType accountType = type == 0 ? SAVING : CHECKING;
        controller.createAccount(accountType, name);
        System.out.println("Account added");
        System.out.print("Initial balance is 100");
    }

    private  void searchAccount() {
        System.out.print("Enter account holder name to search: ");
        // clear previous input before input name
        String skip = scanner.nextLine();
        String name = scanner.nextLine();

        Account account = controller.searchAccount(name);
        if (account != null) {
            printAccountDetails(account);
            accountMenu();
        } else {
            System.out.println("No matches found");
        }
    }

    private void printAccountDetails(Account account) {
        System.out.println("\nAccounts");
        System.out.println("Name : " + account.getName());
        System.out.println("Account No. : " + account.getAccNo());
        System.out.println("Account Type : " + account.toString());
        System.out.println("Balance : " + account.getBalance());
    }

    private void accountMenu(){
        Account account = controller.getSelectedAccount();
        System.out.println("Enter the amount you want to withdraw");
        System.out.println("Current balance is " + account.getBalance());

        double amount = scanner.nextDouble();
        controller.withdraw(amount);
    }

}
