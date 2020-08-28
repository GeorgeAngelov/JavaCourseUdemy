package com.timbuckalka;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your year of birth: ");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();  //handle nextline character (enter key)
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        int age = 2020 - yearOfBirth;

        System.out.println("Yur name is " + name + ", and you are " + age + " years old");



        scanner.close();

    }
}
