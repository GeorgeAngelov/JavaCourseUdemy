package academy.learnprograming;

public class Main {

    public static void main(String[] args) {
	    float myMinFloat = Float.MIN_VALUE;
	    float myMaxFloat = Float.MAX_VALUE;
        System.out.println("Float MIN = " + myMinFloat);
        System.out.println("Float MAX value =" + myMaxFloat);

        double myMindouble = Double.MIN_VALUE;
        double myMaxdouble = Double.MAX_VALUE;
        System.out.println("double MIN = " + myMindouble);
        System.out.println("double MAX value =" + myMaxdouble);

        int myInValue = 5 / 3;
        float MyFloat = 5f / 3f;
        double myDouble = 5.00 / 3.00d;
        System.out.println("My Int VAlue = " + myInValue);
        System.out.println("My Double = " + myDouble);
        System.out.println("My Float = " + MyFloat);

        double numberOfPound = 200d;
        double convertedInKilos = numberOfPound * 0.45359237;
        System.out.println("kilos = " + convertedInKilos);

    }
}
