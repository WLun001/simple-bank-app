package com.company;

import java.util.UUID;

public abstract class Account {
    protected String accNo;
    protected String name;
    protected double balance;

    public Account() {
    }

    public Account(String name) {
        this.name = name;
        this.accNo = UUID.randomUUID().toString();
        this.balance = 0.0;
    }

    public String getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    abstract void withdraw(double amount);

}
