package com.timbuckalka;

public class Sum3and5Challange {
        public static void sum(){
            int counter = 0;
            int sum = 0;
            for (int i=1; i<=1000; i++){
                if (i % 3 == 0 && i % 5 == 0){
                    sum  +=  i;
                    counter++;
                    System.out.println("Number " + i + " is devisable by 3 and 5");
                }
                if (counter == 5){
                    break;
                }
            }
            System.out.println("The sum is " + sum);
        }
}
