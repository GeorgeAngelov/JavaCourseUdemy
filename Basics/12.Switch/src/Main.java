public class Main {

    private static final String INVALID_VALUE_MESAGE = "Not Found!";

    public static void main(String[] args) {
        int value = 1;

        switch (value){ //byte short int char string
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("was 3 or 4 or 5");
                break;
            default:
                System.out.println("Was not 1 or 2");
                break;
        }

        char charValue = 'g';

        switch (charValue){
            case 'A':
                System.out.println("A was found");
                break;
            case 'B':
                System.out.println("B was found");
                break;
            case 'C':
                System.out.println("C was found");
                break;
            case 'D':
                System.out.println("D was found");
                break;
            default:
                System.out.println(INVALID_VALUE_MESAGE);
        }

        String month = "January";
        switch (month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "february":
                System.out.println("Feb");
                break;
            default:
                System.out.println(INVALID_VALUE_MESAGE);
        }

        //
    }
}
