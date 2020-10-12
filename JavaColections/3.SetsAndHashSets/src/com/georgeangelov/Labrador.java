package com.georgeangelov;

public class Labrador extends Dog{

    public Labrador(String name) {
        super(name);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this==obj){
//            return true;
//        }
//
//        if (obj instanceof Dog){
//            String objName = ((Labrador) obj).getName();
//            return this.getName().equals(objName);
//        }
//
//        return false;
//    }
}
