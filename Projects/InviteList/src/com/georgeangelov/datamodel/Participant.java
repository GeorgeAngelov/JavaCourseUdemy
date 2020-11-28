package com.georgeangelov.datamodel;

public class Participent {

    private String name;
    private String adress;

    public Participent(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return name;
    }
}
