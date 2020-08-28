package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
	    String numberAssString = "2018.125";
        System.out.println("numberAssString = " + numberAssString);

        double number = Double.parseDouble(numberAssString);
        System.out.println("number = " + number);

        numberAssString += 1;
        number += 1;

        System.out.println("numberAssString = " + numberAssString);
        System.out.println("number = " + number);
    }
}
