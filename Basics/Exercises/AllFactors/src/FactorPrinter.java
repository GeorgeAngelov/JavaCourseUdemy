public class FactorPrinter {

    private static final String INVALIG_VALUE_MESSAGE = "Invalid Value";
    public static void printFactors(int number){
        if (number < 1){
            System.out.println(INVALIG_VALUE_MESSAGE);
        }
        for (int i = 1;i<=number;i++){
            if (number%i==0){
                System.out.println(i);
            }
        }
    }
}
