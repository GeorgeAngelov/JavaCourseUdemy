package com.timbuckalka;

public class VipCustomer {

    private  String name;
    private double creditLimit;
    private String email;

    public VipCustomer(String name, double creditLimit, String email){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public VipCustomer(){
        this("Pencho",100, "pen4o@abv.bg");

    }

    public  VipCustomer(String name, double limit){
        this(name,limit,"vanka@abv.bg");

    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
