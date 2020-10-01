package com.georgeangelov;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
       //Change the program to allow players to type full words, or phrases,
        // then move to the correct location based upon their input
        //The player should be able to type commands such as "Go West", "run South", or just "East"
        //and the program will move to the appropriate location if there is one. As at present ,
        // an attempt to move in an invalid direction should print a message and remain in the same place.
        //
        //Single letter commands (N, W, S, E, Q) should still be available.


        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0,"You are sitting in front of a computer learning Java",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1,"You are standing at the end of a road before a small brick building",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N",5);
        locations.put(2, new Location(2,"You are at the top of a hill",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("W",1);
        locations.put(3, new Location(3,"You are inside a building, a wll house for a small spring",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4,"You are in a valley beside a stream",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5,"You are in the forest",tempExit));


        Map<String,String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");
        vocabulary.put("SOUTH","S");

        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("S");
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length()>1){
                String[] words = direction.split(" ");
                for (String word : words){
                    if (vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                    }
                }
            }
            /*******************MY**CODE************/
//            String input = scanner.nextLine().toUpperCase();
//            if (input.length()>1) {
//                String[] inputArr = input.split(" ");
//                for (String text : inputArr){
//                    switch (text){
//                        case "EAST":
//                            direction = "E";
//                            break;
//                        case "WEST":
//                            direction = "W";
//                            break;
//                        case "NORTH":
//                            direction = "N";
//                            break;
//                        case "SOUTH":
//                            direction = "S";
//                        case "QUIT":
//                            direction = "Q";
//                            break;
//                    }
//                }
//            }else {
//                 direction = input;
//            }
            /********************************************/

            if (exits.containsKey(direction)){
                loc=exits.get(direction);
            }else {
                System.out.println("You can`t go in this direction");
            }
        }
    }
}
