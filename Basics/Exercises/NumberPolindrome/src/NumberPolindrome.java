public class NumberPolindrome {

    public static boolean isPalindrome(int number){
        if (number == 0 ){
            return true;
        }
        int copy = number;
        int reversedNumber = 0;

        while (number != 0 ){
            reversedNumber = number%10 + reversedNumber*10;
            number /= 10;
        }
   //     System.out.println(reversedNumber);
        if (copy == reversedNumber){
            return true;
        }else
            return false;
    }
}
