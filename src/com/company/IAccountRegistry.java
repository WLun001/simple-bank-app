package com.company;

import java.util.ArrayList;

public interface IAccountRegistry {
    void addAccount(AccountType accountType, String name);

    Account searchAccount(String name);

    int getNumberOfAccounts(AccountType... accountType);

    ArrayList<Account> getAccounts(AccountType... accountType);

    enum AccountType {SAVING, CHECKING}
}
