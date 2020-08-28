public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        if (number<0){
            return -1;
        }

        int sum = number %10;
        boolean isLast = false;

        do {
            if (number<10){
                isLast =true;
                sum+=number;
                continue;
            }
            number/=10;
        }
        while (isLast==false);

        return sum;
    }
}
