package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();
        calcFeetAndInchesToCentimeters(10,9);
        calcFeetAndInchesToCentimeters(12,13);
        calcFeetAndInchesToCentimeters(120);
    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score*1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed player  scored " + score + " points");
        return score*1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score! ");
        return 0;
    }

//    Create a method called calcFeetAndInchesToCentimeters
//    It needs to have two parameters.
//
//    You should validate the first parameter feet is >= 0.
//    You should validate the second parameter inches >=0 and <= 12
//    return -1 from the method if either of the above is not true
//
//    If the parameters are valid, then calculate how many
//    centimeters comprise the feet and inches
//    passed to this method and return that value.
//
//    Create a second method of the same name but with only one parameter
//    inches is the parameter
//    validate that its >=0
//    return -1 if it`s not true
//    But if it`s valid, then calculate how many feet are in the inches
//    Call the overloaded method passing the correct feet and inches
//    calculated so that it can calculate correctly.
//    hints: Use double for your number datatypes is probably a good idea
//    1 inch = 2.54cm and one foot = 12 inches
    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if (feet >= 0 && (inches >= 0 && inches <= 12 )) {
            System.out.println(feet + "ft and " + inches + "in = " + 2.54 * (12 * feet + inches) + "cm");  //centimeters
            return 0;
        }else {
            System.out.println("Invalid value!");
            return -1;
        }
    }
    public static double calcFeetAndInchesToCentimeters(int inches){
        if (inches >= 0){
            int feet =  inches/12;
            inches = inches - 12*feet;
            return calcFeetAndInchesToCentimeters(feet,inches);
        }else {
            System.out.println("Invalid value!");
            return -1;
        }
    }
}
