package com.timbuckalka;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int myIntvalue = 10;
	    int anotherIntValue = myIntvalue;
        System.out.println("myIntvalue= " +myIntvalue);
        System.out.println("anotherIntValue= " + anotherIntValue);

        anotherIntValue++;

        System.out.println("myIntvalue= " +myIntvalue);
        System.out.println("anotherIntValue= " + anotherIntValue);

        int[] myIntArray = new int[5];
        int[] antherArray = myIntArray; // same memory space as myIntArray

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(antherArray));

        antherArray[0] = 1;

        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(antherArray));

        antherArray = new int[]{1, 2, 3, 4, 5}; //de-refference
        modifyArray(myIntArray);

        System.out.println("after modify myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after modify anotherArray = " + Arrays.toString(antherArray));


    }

    private static void modifyArray(int[] array){
        array[0] = 2;
        array = new int[] {1, 2, 3, 4, 5};
    }
}
