package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
        // Create a class and demonstate proper encapsulation techniques
        // the class will be called Printer
        // It will simulate a real Computer Printer
        // It should have fields for the toner Level, number of pages printed, and
        // also whether its a duplex printer (capable of printing on both sides of the paper).
        // Add methods to fill up the toner (up to a maximum of 100%), another method to
        // simulate printing a page (which should increase the number of pages printed).
        // Decide on the scope, whether to use constructors, and anything else you think is needed.

//        Printer nonDuplex = new Printer(100,false);
//
//        Printer duplex = new Printer(10, true);
//
//        nonDuplex.fillUpToner(200);
//        nonDuplex.fillUpToner(70);
//
//        duplex.printPages(10);
//        duplex.fillUpToner(100);
//
//        nonDuplex.printPages(60);
//        nonDuplex.printerStatus();
//
//        duplex.printPages(51);
//        duplex.printerStatus();

        Printer printer = new Printer(50,false);
        System.out.println("initial page count = " + printer.getNumberOfPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " new total page count for printer = " + printer.getNumberOfPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + " new total page count for printer = " + printer.getNumberOfPagesPrinted());

    }
}
