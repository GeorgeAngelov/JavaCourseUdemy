package com.timbuckalka;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Contacts> phoneBook = new ArrayList<Contacts>();

    public static void printListOfContacts(){
        System.out.println("Contacts:");
        phoneBook.forEach(contact -> System.out.println("\t" + contact.getName() + "\t" + contact.getNumber()));
    }

    public static void addNewContact(){
        phoneBook.add(new Contacts(inputName(),inputNumber()));
        System.out.println("Contact created");
    }

    public static void updateExistingContact(){
        System.out.println("Enter the contact detail you want to keep: ");
        String searchItem = scanner.nextLine();

        Contacts temp = findContact(searchItem);

        if (temp.getName().equals(searchItem)){
            temp.setNumber(inputNumber());
        }else if (temp.getNumber().equals(searchItem)){
            temp.setName(inputName());
        }else {
            System.out.println("No contact with this detail!");
        }

        phoneBook.remove(findContact(searchItem));
        phoneBook.add(temp);

        System.out.println("Contact updated!");
    }

    public static void removeContact(){
        System.out.println("Enter contact detail of the contact you want to remove: ");
        String searchItem = scanner.nextLine();
        if(phoneBook.remove(findContact(searchItem))){
            System.out.println("Contact removed!");
        }else
        System.out.println("No contact with this detail");
    }

    public static void searchContact(){
        System.out.println("Enter detail: ");
        String searchItem = scanner.nextLine();
        System.out.println("\n" + findContact(searchItem).getName() +"\t " + findContact(searchItem).getNumber());
    }
    private static void removeContact(Contacts contact){
        phoneBook.remove(contact);
    }

    private static Contacts findContact(String searchItem){
        for (int i = 0;i < phoneBook.size();i++){
            if (phoneBook.get(i).getNumber().equals(searchItem) || phoneBook.get(i).getName().equals(searchItem)){
                return phoneBook.get(i);
            }
        }
        return null;
    }

    private static String inputName(){
        System.out.println("Enter new contact name: ");
        return scanner.nextLine();
    }

    private static String inputNumber(){
        System.out.println("Enter new number: ");
        return scanner.nextLine();
    }
}
