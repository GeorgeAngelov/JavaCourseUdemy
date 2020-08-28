import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage(){

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        double averige = 0.0d;
        int counter = 0;

        while (true){
            System.out.println("Enter number:");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                sum += scanner.nextInt();
                counter++;
            }else {
                break;
            }
            scanner.nextLine();
        }
        averige = (double) sum/counter;
        System.out.println("SUM = " + sum + " AVG = " + Math.round(averige));
        scanner.close();
    }
}
