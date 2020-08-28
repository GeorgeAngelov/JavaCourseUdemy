package academy.learnprograming;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2; // 1 +2 = 3
        System.out.println(result-1);
        System.out.println(result%2);

        boolean isAlien = false;
        if (isAlien == false)
            System.out.println("It is not alien!");

        int topScore = 80;
        if (topScore == 80){
            System.out.println("You got the high score!");
        }
        int  secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore < 100)){
            System.out.println("Greater than second top score!");
        }

        if((topScore > 90) || (secondTopScore <= 90)){
            System.out.println("Either or both of the condittions are true!");
        }

        int newValue = 50;
        if (newValue == 50){
            System.out.println("This is an true!");
        }

        boolean isCar = true;
        if (isCar == true){
            System.out.println("This is not supposed to happen!");
        }

        boolean wasCar = isCar ? true : false;
        if (wasCar){
            System.out.println("wasCar is true");
        }

        //Challange

        double varDouble = 20d;
        double secondVarDouble = 80d;

        double resultChallange = (varDouble + secondVarDouble) * 100.00d;
        System.out.println(resultChallange);

        double remainder = resultChallange % 40.0d;
        System.out.println(remainder);

        boolean isNoRemainder = (remainder == 0) ? true : false;
        System.out.println(isNoRemainder);
    }
}
