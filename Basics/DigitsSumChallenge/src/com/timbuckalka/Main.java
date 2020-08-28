package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
	    // Write a method with the name sumDigits thath has one int parameter called number.
        // If the parameter value is >=10 then the method should precess the number and return sum of all diggits, otherwise return -1 to indicate an ivalid value.
        //The numbers from 0-9 have 1 digit so we don`t want to process them, also we dont want to process negative numbers,so also return -1 for negative numbers.
        // Calling the method sumDiggits(125) should return 8 since 1+2+5 = 8
        // Calling the method sumDigits(1) should return -1 as per requirements described above.
        System.out.println("sum is: " + sumDigits(125));
        System.out.println("sum is: " + sumDigits(-1524));
        System.out.println("sum is: " + sumDigits(1));

    }

    public static int sumDigits(int number){
        if (number<10){
            return -1;
        }

        int sum =0;

        while (number > 0 ){
            sum += number % 10;
            number /=10;
        }
        return sum;
    }
}
