package com.company.registry.domain;

public class SavingAccount extends Account {
    public SavingAccount(String name) {
        super(name);
    }

    @Override
    void withdraw(double amount) {
        this.balance = -amount;
    }

    @Override
    public String toString() {
        return "Saving Account";
    }
}
