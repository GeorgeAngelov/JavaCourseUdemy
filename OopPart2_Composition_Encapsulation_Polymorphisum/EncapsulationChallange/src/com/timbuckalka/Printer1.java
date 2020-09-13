package com.timbuckalka;

public class Printer1 {
    private int tonerLevel;
    private int numberOfPagesPrinted;
    private boolean isDuplex;

    public Printer1( int tonerLevel, boolean isDuplex) {
        if(tonerLevel > -1 && tonerLevel<=100){
            this.tonerLevel = tonerLevel;
        }else {
            this.tonerLevel = -1;
        }

        this.numberOfPagesPrinted = 0;
        this.isDuplex = isDuplex;
    }

    public int fillUpToner(int inkAmount){
        if(inkAmount > 0 && inkAmount<=100) {
            if (this.tonerLevel + inkAmount > 100) {
                return -1;
            }
            this.tonerLevel += inkAmount;
            return this.tonerLevel;
//            System.out.println("Toner cartrige is " + this.tonerLevel + "% full");
        }else
            return -1;
    }

    public void printPages(int pages){
//        if (tonerLevel< pagesToPrint){
//            System.out.println("Low on ink! Recharge!");
//        }else if (isDuplex) {
//            pagesToPrint /= 2;
//            this.numberOfPagesPrinted += pagesToPrint;
//            this.tonerLevel -= pagesToPrint*2;
//            System.out.println("Pages printed: " + pagesToPrint);
//        }else{
//            this.numberOfPagesPrinted += pagesToPrint;
//            this.tonerLevel -= pagesToPrint;
//            System.out.println("Done!");
//        }
        int pagesToPrint = pages;

    }

    public void printerStatus(){
        System.out.println("Total pages Printed: " + this.numberOfPagesPrinted);
        System.out.println("Toner level is at " + this.tonerLevel + "%");
    }
}
