package com.company.registry.ui;

import com.company.registry.domain.Account;
import com.company.registry.domain.Controller;
import com.company.registry.domain.IAccountRegistry;
import com.company.registry.domain.IAccountRegistry.AccountType;
import com.company.registry.domain.RegistryAccountList;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.registry.domain.IAccountRegistry.AccountType.CHECKING;
import static com.company.registry.domain.IAccountRegistry.AccountType.SAVING;

public class BankApp {
    private static IUserInterface userInterface;
    private static  Controller controller;

    public static void main(String[] args){
        userInterface = new ConsoleUI();
        controller = new Controller();
        userInterface.setController(controller);
        userInterface.start();
    }
}
