package com.timbuckalka;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a program using arrays that sorts a list of integers in descending order.
        // Descending order is highest value to lowest.
        // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
        // ultimately have an array with 106,81,26, 15, 5 in it.
        // Set up the program so that the numbers to sort are read in from the keyboard.
        // Implement the following methods - getIntegers, printArray, and sortIntegers
        // getIntegers returns an array of entered integers from keyboard
        // printArray prints out the contents of the array
        // and sortIntegers should sort the array and return a new array containing the sorted numbers
        // you will have to figure out how to copy the array elements from the passed array into a new
        // array and sort them and return the new sorted array.
        System.out.println("Enter array length!\r");
        int arrayLength = scanner.nextInt();

        int[] array = getIntegers(arrayLength);

        printArray(array);

        int[] sortedArray = sortArray(array);

        System.out.println("Printing sorted array!");
        printArray(sortedArray);
    }

    public static int[] getIntegers(int number){
        int[] array = new int[number];
        for (int i=0;i< array.length;i++){
            System.out.println("Enter " + (i+1) + " number in the array: \r");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static void printArray(int[] array){
        for (int i=0;i< array.length;i++){
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }

    public static int[] sortArray(int[] array){
        int[] sortedArray = Arrays.copyOf(array,array.length);
//        for (int i=0;i< array.length;i++){
//            sortedArray[i] = array[i];
//        }
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for (int i=0;i< sortedArray.length-1;i++){
                if (sortedArray[i]< sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i]=sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag=true;
                }
            }
        }
//        Arrays.sort(array);
//       int parameter = 0;
//       int[] sortedArray = new int[array.length];
//       for (int i=array.length-1;i>-1;i--){
//           sortedArray[parameter] = array[i];
//           parameter++;
//       }
       return sortedArray;
    }
}
