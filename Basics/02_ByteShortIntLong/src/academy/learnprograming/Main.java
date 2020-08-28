package academy.learnprograming;

public class Main {

    public static void main(String[] args) {

        int myValue = 100000;
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Integer min Value = " + myMinIntValue);
        System.out.println("Integer max value =" + myMaxIntValue);
        System.out.println(("Busted Max value = ") + (myMaxIntValue +1));

        int myMaxIntTest = 2_147_483_647;

        short myMintShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;

        System.out.println("Short Min Value=" + myMintShortValue);
        System.out.println("Short Max Value=" + myMaxShortValue);
        
        long MyLong = 100L;

        long myMintLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;

        System.out.println("Long Min Value=" + myMintLongValue);
        System.out.println("Long Max Value=" + myMaxLongValue);
        
        
    }
}
