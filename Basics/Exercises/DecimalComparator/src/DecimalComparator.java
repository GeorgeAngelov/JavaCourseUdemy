public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum){

        int convertedFirstNum = (int) (firstNum * 1000);
        int convertedSecondNum = (int) (secondNum * 1000);

        if (convertedFirstNum == convertedSecondNum){
            return true;
        }else{
            return false;
        }
    }

}
