package com.company.registry.ui;

import com.company.registry.domain.Account;
import com.company.registry.domain.IAccountRegistry;
import com.company.registry.domain.IAccountRegistry.AccountType;
import com.company.registry.domain.RegistryAccountList;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.registry.domain.IAccountRegistry.AccountType.CHECKING;
import static com.company.registry.domain.IAccountRegistry.AccountType.SAVING;

public class BankApp {
    private static Scanner scanner;
    private static IAccountRegistry accounts;

    public static void main(String[] args) {
        accounts = new RegistryAccountList();
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

    public static void displayAccount() {
        System.out.print("List account by: (0 - All, 1 - Saving , 2 - Checking): ");
        int choice = scanner.nextInt();

        ArrayList<Account> accountList;
        if (choice != 0) {
            AccountType type = choice == 1 ? SAVING : CHECKING;
            accountList = accounts.getAccounts(type);
        } else accountList = accounts.getAccounts();

        for (Account account : accountList) {
            printAccountDetails(account);
        }

    }

    public static void addAccount() {
        System.out.print("Enter account holder name: ");
        // clear previous input before input name
        String skip = scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter account type: (0 - Saving, 1 - Checking): ");
        int type = scanner.nextInt();
        AccountType accountType = type == 0 ? SAVING : CHECKING;
        accounts.addAccount(accountType, name);
        System.out.println("Account added");
    }

    public static void searchAccount() {
        System.out.print("Enter account holder name to search: ");
        // clear previous input before input name
        String skip = scanner.nextLine();
        String name = scanner.nextLine();

        Account account = accounts.searchAccount(name);
        if (account != null) {
            printAccountDetails(account);
        } else {
            System.out.println("No matches found");
        }
    }

    private static void printAccountDetails(Account account) {
        System.out.println("\nAccounts");
        System.out.println("Name : " + account.getName());
        System.out.println("Account No. : " + account.getAccNo());
        System.out.println("Account Type : " + account.toString());
        System.out.println("Balance : " + account.getBalance());
    }
}
