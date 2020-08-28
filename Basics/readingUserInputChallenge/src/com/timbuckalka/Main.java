package com.timbuckalka;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Read 10 numbers from the console entered by the user and print the sum of those numbers.
        //Crate a Scanner.
        //Use the hasNextInt() method from the scanner to check if the user has entered an int value.
        //If hasNextInt() returns false, print the message "Invalid Number". Continue reading until you have read 10 numbers.
        //Use the nextInt() method to get the number and add it to the sum.
        // Before the user enters each number, print the message "Enter number #x: " where x represents the count, i.e. 1,2,3,4 etc.
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        int sum = 0;

        while (count<=10){
            System.out.println("Enter number #" + count + ": ");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt){
                sum += scanner.nextInt();
                count++;
            }else {
                System.out.println("Invalid Number");
            }
            scanner.nextLine(); // handle end of line(enter key)
        }
        System.out.println("The sum is : " + sum);
        scanner.close();
    }
}
