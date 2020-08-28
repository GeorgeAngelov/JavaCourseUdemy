package com.timbuckalka;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value!";

    public static void main(String[] args) {

        System.out.println(getDurationString(100L,59L));
        System.out.println(getDurationString(3758L));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65,9));
    }

    private static String getDurationString(long minutes, long seconds){
        if(minutes < 0 || (seconds < 0 || seconds >= 60)){
            return INVALID_VALUE_MESSAGE;
        }else{
            long hours = minutes/60;
            minutes = minutes % 60;

            String hoursString = hours + "h ";
            if (hours < 10 ) {
                hoursString = "0" + hoursString;
            }

            String minutesString = minutes + "m ";
            if(minutes < 10){
                minutesString = "0" + minutesString;
            }

            String secondsString = seconds + "s";
            if (seconds < 10){
                secondsString = "0" + secondsString;
            }

            return hoursString + minutesString + secondsString;
        }
    }

    private static String getDurationString(long seconds){
        if (seconds < 0){
            return INVALID_VALUE_MESSAGE;
        }else {
            long minutes = seconds / 60;
            seconds = seconds % 60;
             return getDurationString(minutes,seconds);
        }
    }
}
