public class MinutesToYearsDaysCalculator {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void printYearsAndDays(long minutes){
        if (minutes < 0){
            System.out.println(INVALID_VALUE_MESSAGE);
        }else {
            long days = (minutes / 60)/24;
            long years = days/365;
            days = days % 365;

            String minutesString = minutes + " min = ";

            String yearsString = years + " y and ";

            String daysString = days + " d";

            System.out.println(minutesString + yearsString + daysString);
        }
    }
}
