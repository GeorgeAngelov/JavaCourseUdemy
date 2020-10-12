package com.georgeangelov;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        double minValue = Integer.MAX_VALUE;
        double maxValue = Integer.MIN_VALUE;
        String minMonth = null;
        String maxMonth = null;
        double average = 0;


        Map<String,Double> ledger = new HashMap<>();

        ledger.put("January", 14.5);
        ledger.put("February", 25.4);
        ledger.put("March", 54.0);
        ledger.put("April", 32.5);
        ledger.put("May", 84.5);
        ledger.put("June", 6.5);
        ledger.put("July", 64.5);
        ledger.put("August", 16.5);
        ledger.put("September", 14.5);
        ledger.put("October", 19.5);
        ledger.put("November", 27.5);
        ledger.put("December", 123.5);



        for (String key : ledger.keySet()){
            if (ledger.get(key)< minValue){
                minValue = ledger.get(key);
                minMonth = key;
            }
            if (ledger.get(key)>maxValue){
                maxValue = ledger.get(key);
                maxMonth = key;
            }
            average += ledger.get(key);
        }

        System.out.println("Min value: " + minMonth + "\t" + minValue);
        System.out.println("Max value: " + maxMonth + "\t" + maxValue);
        System.out.println("Average: " + average/ledger.size());


    }
}
