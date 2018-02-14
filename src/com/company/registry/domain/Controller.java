package com.company.registry.domain;

import com.company.registry.domain.IAccountRegistry.AccountType;

import java.util.ArrayList;

public class Controller {

    private IAccountRegistry accountRegistry;
    private Account account;

    public Controller(){
        this.accountRegistry = new RegistryAccountList();
    }

    public Account getSelectedAccount(){
        return account;
    }

    public void createAccount(AccountType accountType, String name){
        accountRegistry.addAccount(accountType, name);
    }

    public Account searchAccount(String name){
        return accountRegistry.searchAccount(name);
    }

    public int getNumberofAccounts(AccountType... accountType){
        return accountRegistry.getNumberOfAccounts(accountType);
    }

    public ArrayList<Account> getAccounts(AccountType... accountType){
        return accountRegistry.getAccounts(accountType);
    }

}
