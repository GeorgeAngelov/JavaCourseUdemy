package com.timbuckalka;

public class Printer {

    private int tonerLevel;
    private int numberOfPagesPrinted;
    private boolean isDuplex;

    public Printer( int tonerLevel, boolean isDuplex) {
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

    public int printPages(int pages){
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
        if (this.isDuplex){
            pagesToPrint  = (pages/2) + (pages%2);
            System.out.println("Printing in duplex");
        }
        this.numberOfPagesPrinted += pagesToPrint;
        return pagesToPrint;

    }

    public void printerStatus(){
        System.out.println("Total pages Printed: " + this.numberOfPagesPrinted);
        System.out.println("Toner level is at " + this.tonerLevel + "%");
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }
}
