package com.timbuckalka;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Read the numbers from the console entered by the user and print the minimum and maximum number the user has entered
        //Before the user enters the number print the message "Enter number:"
        //If the user enters an invalid number, break out of the loop and print the minimum and maximum number.
        //Use an endless while loop
        Scanner scanner = new Scanner(System.in);

        int number = Integer.MIN_VALUE;
        int secondNumber = 0;
        int min= Integer.MAX_VALUE;

        while (true){
            System.out.println("Enter number");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt){
                secondNumber =scanner.nextInt();
                if (secondNumber>number){
                    number=secondNumber;
                }else if (secondNumber<min){
                    min = secondNumber;
                }
            }else {
                break;
            }
            scanner.nextLine(); // handle input
        }
        scanner.close();
        System.out.println("Biggest number is: " + number);
        System.out.println("Smallest number is: " + min);
    }
}
