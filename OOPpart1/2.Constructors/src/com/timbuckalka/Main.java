package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
	    //Create a new class for a bank account
        //Create fields for the account number, balance, customer name, email and phone number.

        //Create getters and setters for each field
        // Create two additional methods
        // 1. To allow the customer to deposit funds (this should increment the balance field).
        // 2. To allow the customer to withdraw funds. This should deduct from the balance field,
        // but not allow the withdrawal to complete if their are insufficient funds.
        // You will want to create various code int the Main Class to confirm your code is working

        BankAccount Pen4o = new BankAccount();
        BankAccount John = new BankAccount(12548, 0.0d, "Bob Brown", "john@abv.bg", "087745008");
        BankAccount tim = new BankAccount("Tim", "tim@abv.bg", "000000011");
        //        John.setAccountNumber(1112255776);
//        John.setBalance(100d);
//        John.setCustomerName("John Peterson");
//        John.setEmail("pen4o@abv.bg");
//        John.setPhoneNumber("0877450081");
        tim.deposit(10);
        Pen4o.deposit(20);
        John.deposit(25d);
        John.withdraw(200);
        John.withdraw(15);

        // Create a new class VipCustomer
        // it should have 3 fields name , credit limit and email address.
        //create 3 constructors
        // 1st constructor empty should call the constructor with 3 parameters with default values
        // 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
        // 3rd constructor should save all fields.
        // create getters fot this using code generation of intellij as setters wont ne needed.
        //test and confirm

        VipCustomer Pencho = new VipCustomer();
        System.out.println(Pencho.getName());

        VipCustomer Vanka = new VipCustomer("vanka",200);
        System.out.println(Vanka.getName());

        VipCustomer Stef4o = new VipCustomer("stef4o",3000,"stef4o@abv.bg");
        System.out.println(Stef4o.getName());
    }
}
