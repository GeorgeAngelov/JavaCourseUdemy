package com.timbuckalka;

public class BankAccount {

    private  long accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(){
        this(11154, 25.0d, "Default name", "Default adress", "0000000");
        System.out.println("Empty constructor called");
    }

    public BankAccount(long accountNumber, double balance, String customerName, String email, String phoneNumber){
        System.out.println("Account constructor called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this(112254, 100, customerName,email,phoneNumber);
//        this.customerName = customerName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(long accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void deposit(double deposit){
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Name: " + getCustomerName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Old balance: " + getBalance());
        System.out.println("***************************");
        System.out.println("Amount added: " + deposit);
        this.balance += deposit;
        System.out.println("New balance: " + getBalance());
    }
    public void withdraw(double amount){
        if (getBalance()<=amount){
            System.out.println("Not enough money! ");
        }else {
            System.out.println("Account number: " + getAccountNumber());
            System.out.println("Name: " + getCustomerName());
            System.out.println("Phone: " + getPhoneNumber());
            System.out.println("Email: " + getEmail());
            System.out.println("Old balance: " + getBalance());
            System.out.println("***************************");
            System.out.println("Amount deducted: " + amount);
            this.balance-=amount;
            System.out.println("New balance: " + getBalance());
        }
    }
}
