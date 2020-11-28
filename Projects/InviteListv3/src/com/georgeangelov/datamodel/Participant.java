package com.georgeangelov.datamodel;

import java.io.Serializable;

public class Participant implements Serializable {

    private String name;
    private String adress;

    private long serialVersionUID = 1L;

    public Participant(String name, String adress) {
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

    @Override
    public boolean equals(Object obj) {
        boolean result;
        if ((obj == null) || (getClass() != obj.getClass())){
            result = false;
        }else {
            Participant participant = (Participant)obj;
            result = name.equals(((Participant) obj).name) && adress.equals(((Participant) obj).adress);
        }
        return result;
    }
}
