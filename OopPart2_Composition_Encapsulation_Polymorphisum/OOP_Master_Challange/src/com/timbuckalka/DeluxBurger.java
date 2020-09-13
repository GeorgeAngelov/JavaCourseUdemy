package com.timbuckalka;

public class DeluxBurger extends Hamburger {

    public DeluxBurger() {
        super("Delux", "White", "Sausage & Bacon", 14.54);
        super.addHambergerAdition1("Chips", 2.57);
        super.addHambergerAdition2("Drink", 1.81);
    }

    @Override
    public void addHambergerAdition1(String name, double price) {
        System.out.println("Can not add additional items to delux burger");
    }

    @Override
    public void addHambergerAdition2(String name, double price) {
        System.out.println("Can not add additional items to delux burger");
    }

    @Override
    public void addHambergerAdition3(String name, double price) {
        System.out.println("Can not add additional items to delux burger");
    }

    @Override
    public void addHambergerAdition4(String name, double price) {
        System.out.println("Can not add additional items to delux burger");
    }
}
