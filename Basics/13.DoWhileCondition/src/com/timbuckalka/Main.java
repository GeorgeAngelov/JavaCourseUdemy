package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
//	    int count = 1;
//
//	    while (count != 6){
//            System.out.println("Count value is  " + count);
//            count++;
//        }
//
//        System.out.println("******************");
//
//	    for (count = 1; count !=6; count++){
//            System.out.println("Count value is " + count);
//        }
//
//        System.out.println("*****************");
//        count = 6;
//	    do{
//            System.out.println("Count value is " + count);
//            count++;
//
//        if (count > 100){
//            break;
//        }
//        }while (count != 6);
//    }
        // Create a method called isEvenNumber that takes a parameter of type int
        //Its purpose is to determine if the argument passed to the method is
        //an even number or not
        //return true if an even number is found, otherwise return false

        int number = 4;
        int finishNumber = 20;
        int count = 0;

        while (number<=finishNumber){
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }
            System.out.println("Even number " + number);
            count ++;
            if ( count >=5){
                break;
            }

        }
        System.out.println("Total numbers are " + count);



    }
    public  static boolean isEvenNumber( int number){
        if (number % 2 == 0) {
            return true;
        } else
            return false;
    }
}
