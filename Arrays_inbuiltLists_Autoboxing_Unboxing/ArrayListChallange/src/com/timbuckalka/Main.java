package com.timbuckalka;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.
        boolean quit = false;
        int choice = 0;
        printChoiceList();
        while (!quit){
            System.out.println("Pick your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printChoiceList();
                    break;
                case 1:
                    printListOfContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    quit=true;
                    System.out.println("Goodbay!!!!");
                    break;
            }
        }
    }

    private static void printChoiceList(){
        System.out.println("\n Text: ");
        System.out.println("\t 1 - Print the Phonebook.");
        System.out.println("\t 2 - Add new Contact.");
        System.out.println("\t 3 - Update existing Contact");
        System.out.println("\t 4 - Remove contact.");
        System.out.println("\t 5 - Find contact.");
        System.out.println("\t 6 - quit");
    }

    private static void printListOfContacts(){
        MobilePhone.printListOfContacts();
    }

    private static void addNewContact(){
        MobilePhone.addNewContact();
    }

    private static void updateExistingContact(){
        MobilePhone.updateExistingContact();
    }

    private static void removeContact(){
        MobilePhone.removeContact();
    }

    private static void findContact(){
        MobilePhone.searchContact();
    }
}
