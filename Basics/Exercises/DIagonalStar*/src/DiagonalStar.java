public class DiagonalStar {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println(INVALID_VALUE_MESSAGE);
        } else {

            for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= number; j++) {
                    if (i == 1 || i == number) {
                        System.out.print("*");
                    } else if (j == 1 || j == number) {
                        System.out.print("*");
                    } else if (i == j) {
                        System.out.print("*");
                    } else if (i + j == number + 1) {
                        System.out.print("*");
                    } else
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
