public class IntEqualityPrinter {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void printEqual(int firstNum, int secondNum, int thirdNum){
        if (firstNum < 0 || secondNum < 0 || thirdNum < 0){
            System.out.println(INVALID_VALUE_MESSAGE);
        }else if (firstNum == secondNum && secondNum == thirdNum){
            System.out.println("All numbers are equal");
        }else if (firstNum != secondNum && firstNum != thirdNum && secondNum != thirdNum){
            System.out.println("All numbers are different");
        }else {
            System.out.println("Neither all are equal or different");
        }
    }
}
