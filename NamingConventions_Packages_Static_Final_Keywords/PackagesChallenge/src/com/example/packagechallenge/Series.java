package com.example.packagechallenge;

import java.util.ArrayList;

public class Series {

    public static int nSum(int n){
        int sum = 0;
        for (int i = 0; i < n+1;i++){
            sum+=i;
        }
        return sum;
    }

    public static int factorial(int n){
        if (n==0){
            return 0;
        }else {
            int sum = 1;
            for (int i = 1; i < n+1; i++) {
                sum *= i;
            }
            return sum;
        }
    }

    public static int fibonacci(int n){
        if (n == 0){
            return 0;
        }else if (n == 1 || n == 2){
            return 1;
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            list.add(1);
            for (int i = 3; i < n+1; i++) {
                list.add(list.get(i-1) + list.get(i-2));
            }
            return list.get(n);
        }
    }
}
