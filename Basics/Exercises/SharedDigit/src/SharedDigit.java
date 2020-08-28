public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2){
        if ((num1<10 || num1 >99) || (num2 < 10 || num2 > 99)){
            return false;
        }

        int digit;
        boolean isfound = false;

        do {
            digit = num1%10;
            num1 /=10;

            if(num2%10 == digit || num2/10 == digit){
                isfound = true;
                break;
            }else if(num2%10 == num1 || num2/10 == num1){
                isfound = true;
                break;
            }

        }while (isfound == true);

        return isfound;
    }
}
