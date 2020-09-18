package com.timbuckalka;

import java.util.ArrayList;

public class Bank {
        private String name;
        private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public boolean addNewBranch(String branchName){
        Branch branch = findBranch(branchName);
        if (branch == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if (branchName != null){
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for (Branch checkedBranch : this.branches) {
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer customer = branchCustomers.get(i);
                System.out.println("\t" + customer.getName() + " [" + (i+1) + "]");
                if (showTransactions){
                    System.out.println("\t\tTransactions: ");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("\t\t\t[" + (j+1) + "]   Amount: " + transactions.get(j));
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public boolean listBranches(){
        if (branches.size()>1) {
            System.out.println("Branches in " + this.getName() + " Bank: ");
            for (int i = 0; i < branches.size(); i++) {
                System.out.println("[" + (i + 1) + "]\t" + branches.get(i).getName());
            }

            return true;
        }else {
            return false;
        }
    }
}
