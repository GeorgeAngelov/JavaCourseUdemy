package com.georgeangelov;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock=new ReentrantLock();
    }

    public void deposit(double amount) {
//        synchronized (this) {
//        lock.lock();
//        try {
//            balance += amount;
//        }finally {
//            lock.unlock();
//        }
//        }
        boolean status = false;
        try {
            if (lock.tryLock(1000,TimeUnit.MILLISECONDS)){
                try {
                    balance+=amount;
                    status=true;
                }finally {
                    lock.unlock();
                }
            }else {
                System.out.println("Could not get the lock");
            }
        }catch (InterruptedException e){

        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount){
        boolean status = false;
//        synchronized (this){
//        lock.lock();
//        try {
//            balance -= amount;
//        }finally {
//            lock.unlock();
//        }
//        }
       try {
           if (lock.tryLock(1000,TimeUnit.MILLISECONDS)){
               try {
                   balance-=amount;
                   status = true;
               }finally {
                   lock.unlock();
               }
           }else {
               System.out.println("Could not get the lock");
           }
       }catch (InterruptedException e){

       }
        System.out.println("Transaction status = " + status);
    }

    public double getBalance() {
        return balance;
    }

//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }
//
//    public synchronized double getBalance() {
//        return balance;
//    }
    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + accountNumber);
    }
}
