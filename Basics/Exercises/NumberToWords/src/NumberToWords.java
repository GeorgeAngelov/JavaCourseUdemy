public class NumberToWords {

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }
        String numberInWords = "";
        int reversedNumber = reverse(number);
        int numberOfZeros = getDigitCount(number) - getDigitCount(reversedNumber);
        do {
            int digit = reversedNumber % 10;
            switch(digit) {
                case 0:
                    numberInWords += "Zero";
                    break;
                case 1:
                    numberInWords += "One";
                    break;
                case 2:
                    numberInWords += "Two";
                    break;
                case 3:
                    numberInWords += "Three";
                    break;
                case 4:
                    numberInWords += "Four";
                    break;
                case 5:
                    numberInWords += "Five";
                    break;
                case 6:
                    numberInWords += "Six";
                    break;
                case 7:
                    numberInWords += "Seven";
                    break;
                case 8:
                    numberInWords += "Eight";
                    break;
                case 9:
                    numberInWords += "Nine";
                    break;
                default:
                    System.out.println("Invalid input.");
                    return;
            }
            reversedNumber /= 10;
            numberInWords += " ";
        } while (reversedNumber != 0);
        for (int i = 1; i <= numberOfZeros; ++i) {
            numberInWords += "Zero ";
        }
        System.out.println(numberInWords);
    }

    public static int reverse(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber *= 10;
            reversedNumber += number % 10;
            number /= 10;
        }
        return reversedNumber;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        int numberOfDigits = 0;
        do {
            ++numberOfDigits;
            number /= 10;
        } while (number > 0);
        return numberOfDigits;
    }
}
