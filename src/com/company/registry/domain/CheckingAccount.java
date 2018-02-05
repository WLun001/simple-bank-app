package com.company.registry.domain;

public class CheckingAccount extends Account {
    private static final double SERVICE_CHARGE = 0.05;

    public CheckingAccount(String name) {
        super(name);
    }

    @Override
    void withdraw(double amount) {
        this.balance = -(amount * SERVICE_CHARGE) + amount;
    }

    @Override
    public String toString() {
        return "Checking Account";
    }
}
