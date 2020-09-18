package com.timbuckalka;

import java.util.ArrayList;

class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
	    String[] srtArray = new String[10];
	    int[] intArray = new int[10];

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("tim");

        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));

        Integer integer = 54; //Integer.valueOf(54)
        Double doubleValue = 12.25;

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

        for (int i=0;i<=10;i++){
            intArrayList.add(Integer.valueOf(i)); //Autoboxing
        }
        for (int i=0;i<=10;i++){
            System.out.println(i + " --> " + intArrayList.get(i).intValue()); // Unboxing
        }



    }
}
