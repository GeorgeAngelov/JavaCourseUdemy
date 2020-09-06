package com.timbuckalka;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// Write a method called readIntegers() with a parameter called count that represents how many integers the user needs to enter.
    // The method needs to read from the console until all the numbers are entered, and then return an array containing the numbers entered
    //Write a method findMin() with the array as a parameter. The method needs to return the minimum value in the array.
    //In the main()  method read the count from the console and call the method readIntegers()  with the count parameter.
    // Then call the findMin() method passing the array returned from the call to the readIntegers() method.
    // Finally print the minimum element in the array.
        System.out.println("Enter count: \r");
        int count = scanner.nextInt();

        System.out.println("You want to enter " +count+ " numbers!");

        int[] intArray = readIntegers(count);

        System.out.println("The minimum value is: " + findMin(intArray));

    }

    private static int[] readIntegers(int count){
        int[] array = new int[count];
        for (int i=0;i< array.length;i++) {
            System.out.println("Enter number " +(i+1)+":\r");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for (int i=0;i< array.length;i++){
            if (array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
}
