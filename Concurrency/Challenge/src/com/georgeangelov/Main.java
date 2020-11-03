package com.georgeangelov;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
	   final BankAccount account = new BankAccount("12345-678",1000.00);


	    Thread trThread1 = new Thread(new Runnable() {
            @Override
            public  void run() {
                account.deposit(300.00);
                System.out.println("Thread 1: DEPOSITED 300, Current amount is: " + account.getBalance());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//
//                }
                account.withdraw(50.00);
                System.out.println("Thread 1: WITHDREW 50, Current amount is: " + account.getBalance());
            }
        });

	    Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                System.out.println("Thread 2: DEPOSITED 203.75, Current amount is: " + account.getBalance());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//
//                }
                account.withdraw(100.00);
                System.out.println("Thread 2: WITHDREW 100, Current amount is: " + account.getBalance());
            }
        });

//        Thread trThread1 = new Thread(){
//            public void run(){
//                account.deposit(300.00);
//                account.withdraw(50.00);
//            }
//        };
//
//        Thread trThread2 = new Thread(){
//            public void run(){
//                account.deposit(203.75);
//                account.withdraw(100.00);
//            }
//        };
        trThread1.start();
        trThread2.start();
    }
}
