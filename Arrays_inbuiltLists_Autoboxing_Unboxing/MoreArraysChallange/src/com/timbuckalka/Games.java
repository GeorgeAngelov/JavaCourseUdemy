package com.timbuckalka;

import java.util.Arrays;
import java.util.Scanner;

public class Games {
    private static Scanner scanner = new Scanner(System.in);

   // 10.Проверете дали масив от символи е симетричен. Пример ['б','о','б']
    public static void isSymetrical(){
        System.out.println("Is the array symetrical?");

        System.out.println("Enter an array of 6 characters: ");

        String arrayString = scanner.nextLine();
        char[] array = new char[6];
        boolean equal=true;

        array=arrayString.toCharArray();


        for (int i = 0; i < array.length/2 ; i++) {
            if (array[i]==array[array.length-(i+1)]){
                equal=true;
            }else {
                equal=false;
                break;
            }
        }

        if (equal){
            System.out.println("Array is symetrical");
        }else {
            System.out.println("Array is not symetrical");
        }

    }

    //11.Обърнете наобратно елементите на масив

    public static void reverseArray(){

        System.out.println("Reverse an array!");

        System.out.println("Enter an array of 6 characters: ");

        String arrayString = scanner.nextLine();
        char[] array = new char[6];
        char[] reverseArray = new char[6];

        for (int i = 0; i <arrayString.length() ; i++) {
            array=arrayString.toCharArray();
        }

        for (int i =0 ; i < array.length ; i++) {
            reverseArray[i] = array[array.length-(i+1)];
        }

        for (int i = 0; i < reverseArray.length ; i++) {
            System.out.print(reverseArray[i]);
        }
    }

    //Play Tik-Tak-Toe
    public static void tikTakToe(){

        System.out.println("LETS PLAY TIK-TAK-TOE!");
        System.out.println();

        String[][] array = new String[3][3];
        boolean end = false;
        int player = 1;
        int row = 0;
        int column =0;
        String sign;
        String winner = null;

        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = "-";
            }
        }

        printBoard(array);

        while (!end){
            if (player%2 == 0) {
                System.out.println("Player 2 enter  ROW number: ");
                row = scanner.nextInt()-1;
                System.out.println("Player 2 enter COLUMN number: ");
                column = scanner.nextInt()-1;
                sign = "O";
            }else {
                System.out.println("Player 1 enter  ROW number: ");
                row = scanner.nextInt()-1;
                System.out.println("Player 1 enter COLUMN number: ");
                column = scanner.nextInt()-1;
                sign = "X";
            }

            player++;
            array[row][column] = sign;

            printBoard(array);

            winner = checkWinner(array);

            if (winner != null){
                end = true;

                if (winner.equals("X")){
                    System.out.println("PLAYER 1 WINS!");
                    System.out.println("Congratulations");
                }else if (winner.equals("O")){
                    System.out.println("PLAYER 2 WINS!");
                    System.out.println("Congratulations");
                }else {
                    System.out.println(winner);
                }
            }
        }


    }

    private static String checkWinner(String[][] array){ //change for to if
        String winner = null;

        for (int j = 0; j <array.length; j++) {
            if (array[0][j].equals(array[1][j]) && array[0][0].equals(array[2][j])){
                winner = array[0][j];
                if (winner.equals("-")) {
                    return null;
                }else {
                    return winner;
                }
            }
        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i][0].equals(array[i][1]) && array[i][0].equals(array[i][2])){
                winner = array[i][0];
                if (winner.equals("-")) {
                    return null;
                }else {
                    return winner;
                }
            }
        }
        if (array[0][0].equals(array[1][1]) && array[0][0].equals(array[2][2])){
            winner=array[0][0];
            if (winner.equals("-")) {
                return null;
            }else {
                return winner;
            }
        }
        if (array[0][2].equals(array[1][1]) && array[0][2].equals(array[2][0])){
            winner=array[0][2];
            if (winner.equals("-")) {
                return null;
            }else {
                return winner;
            }
        }

        if (winner.equals("-")) {
            return null;
        }else {
            return winner;
        }
    }


    private static void printBoard(String[][] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length ; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

}
