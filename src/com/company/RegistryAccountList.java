package com.company;

import java.util.ArrayList;

import static com.company.IAccountRegistry.AccountType.SAVING;

public class RegistryAccountList implements IAccountRegistry {

    private ArrayList<Account> accounts;

    public RegistryAccountList() {
        accounts = new ArrayList<>();
    }

    @Override
    public void addAccount(AccountType accountType, String name) {
        if (accountType == SAVING) {
            accounts.add(new SavingAccount(name));
        } else {
            accounts.add(new CheckingAccount(name));
        }
    }

    @Override
    public Account searchAccount(String name) {
        Account matchedAcc = null;
        for (Account account : accounts) {
            if (account.name.equals(name)){
                matchedAcc = account;
                break;
            }
        }
        return matchedAcc;
    }

    @Override
    public int getNumberOfAccounts(AccountType... accountType) {
        int count = 0;
        if (accountType.length > 0) {
            if (accountType[0] == SAVING) {
                for (Account account : accounts) {
                    if (account instanceof SavingAccount)
                        count++;
                }
                return count;
            } else {
                for (Account account : accounts) {
                    if (account instanceof SavingAccount)
                        count++;
                }
                return count;
            }
        }

        return accounts.size();
    }

    @Override
    public ArrayList<Account> getAccounts(AccountType... accountType) {
        ArrayList<Account> accountList = new ArrayList<>();
        if (accountType.length > 0) {
            if (accountType[0] == SAVING) {
                for (Account account : accounts) {
                    if (account instanceof SavingAccount)
                        accountList.add(account);
                }
                return accountList;
            } else {
                for (Account account : accounts) {
                    if (account instanceof CheckingAccount)
                        accountList.add(account);
                }
                return accountList;
            }
        } else {
            return accounts;
        }
    }
}
