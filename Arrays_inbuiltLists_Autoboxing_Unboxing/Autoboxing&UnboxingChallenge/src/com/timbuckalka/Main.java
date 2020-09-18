package com.timbuckalka;

import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        // You job is to create a simple banking application.
        // There should be a Bank class
        // It should have an arraylist of Branches
        // Each Branch should have an arraylist of Customers
        // The Customer class should have an arraylist of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
        // Branch:
        // Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank:
        // Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list
        // of their transactions
        // Demonstration autoboxing and unboxing in your code
        // Hint: Transactions
        // Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions

        Bank bank = new Bank("National Bulgarian");
        bank.addNewBranch("Ruse");

        bank.addCustomer("Ruse","George", 15.5);
        bank.addCustomer("Ruse","Mike", 17.5);
        bank.addCustomer("Ruse","Percei", 200.12);

        bank.addNewBranch("Varna");
        bank.addCustomer("Varna","Pen4o", 180);

        bank.addCustomerTransaction("Ruse","George", 13.5);
        bank.addCustomerTransaction("Ruse","Mike", 1.5);
        bank.addCustomerTransaction("Ruse","George", 17.5);

        bank.addCustomerTransaction("Varna","Pen4o", 167.5);

        bank.listCustomers("Ruse",false);
        bank.listCustomers("Varna", true);
        bank.listCustomers("Ruse",true);
    }
}
