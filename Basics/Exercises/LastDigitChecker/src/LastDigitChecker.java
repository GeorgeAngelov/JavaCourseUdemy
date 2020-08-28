public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1, int num2, int num3){
        if((isValid(num1) && isValid(num2)  && isValid(num3))){
            if ((num1 % 10 == num2 % 10) || (num2 % 10 == num3 % 10) || (num1 % 10 == num3 % 10)){
                return true;
            } else
                return false;
        }
        return false;
    }

    public static boolean isValid(int parameter){
        if (parameter>=10 && parameter<=1000){
            return true;
        }else
            return false;
    }
}
