public class AreaCalculator {

    private static final double INVALID_VALUE_MESSAGE = -1d;

    public static double area(double radius){
        if(radius < 0){
            return INVALID_VALUE_MESSAGE;
        }else {
            return radius * radius * Math.PI;
        }
    }

    public static double area(double length, double width){
        if(length < 0 || width < 0){
            return INVALID_VALUE_MESSAGE;
        }else {
            return length * width;
        }
    }
}
