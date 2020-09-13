package com.timbuckalka;

public class Hamburger {

    private String name;
    private String breadRow;
    private String meatType;
    private double price;

    private String addition1Name;
    private double adition1Price;

    private String addition2Name;
    private double adition2Price;

    private String addition3Name;
    private double adition3Price;

    private String addition4Name;
    private double adition4Price;

    public Hamburger(String name, String breadRow, String meatType, double price) {
        this.name = name;
        this.breadRow = breadRow;
        this.meatType = meatType;
        this.price = price;
    }

    public void addHambergerAdition1(String name, double price){
        this.addition1Name = name;
        this.adition1Price = price;
    }

    public void addHambergerAdition2(String name, double price){
        this.addition2Name = name;
        this.adition2Price = price;
    }

    public void addHambergerAdition3(String name, double price){
        this.addition3Name = name;
        this.adition3Price = price;
    }

    public void addHambergerAdition4(String name, double price){
        this.addition4Name = name;
        this.adition4Price = price;
    }

    public double itemizeHamburger(){
        double hambergerPrice = this.price;
        System.out.println(this.name + " hamberger" + " on a " + this.breadRow + " row  with " + this.meatType + " , price is " + this.price);
        if (this.addition1Name != null){
            hambergerPrice += this.adition1Price;
            System.out.println("Added " + this.addition1Name + " for an extra " + this.adition1Price);
        }

        if (this.addition2Name != null){
            hambergerPrice += this.adition2Price;
            System.out.println("Added " + this.addition2Name + " for an extra " + this.adition2Price);
        }

        if (this.addition3Name != null){
            hambergerPrice += this.adition3Price;
            System.out.println("Added " + this.addition3Name + " for an extra " + this.adition3Price);
        }

        if (this.addition4Name != null){
            hambergerPrice += this.adition4Price;
            System.out.println("Added " + this.addition4Name + " for an extra " + this.adition4Price);
        }

        return hambergerPrice;
    }
}
