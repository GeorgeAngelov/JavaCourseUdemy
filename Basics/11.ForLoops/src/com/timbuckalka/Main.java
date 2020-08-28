package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
        System.out.println("10000 at 2 % intrest = " + calculateIntres(10000.0d, 2.0d));

        System.out.println("****************");

        for (int i = 2; i < 9; i++){
            System.out.println("10000 at " +i+ "% interest: " + String.format("%.2f",calculateIntres(10000.0d,i)));
        }

        System.out.println("**************");

        for (int i = 8; i >= 2; i--){
            System.out.println("10000 at " +i+ "% interest: " + String.format("%.2f",calculateIntres(10000.0d,i)));
        }

        System.out.println("**************");

        // Create a for statement using any range of numbers
        //Determine if the number is a prime number using the isPrime methot
        //if it`s a prime number, print it out AND increment a count of the
        //number of prime numbers found
        //if that count is 3 exit the loop

        int count = 0;

        for (int i=2; i < 50; i++){
            if (isPrime(i)){
                System.out.println("Number " + i + " is a Prime number!");
                count++;
                 if (count == 10) {
                     System.out.println("Exiting!");
                     break;
                 }
            }
        }
        System.out.println(count);
        System.out.println("********************");
        Sum3and5Challange.sum();
    }

    public static double calculateIntres(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }

    // is the nember prime
    public static boolean isPrime(int n){
        if (n==1){
            return false;
        }

        for (int i=2; i<=(long) Math.sqrt(n); i++){
            System.out.println("Looping " + i);
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
