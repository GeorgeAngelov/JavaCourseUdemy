package com.timbuckalka;

public class Car extends Vehicle {

    private int wheels;
    private int door;
    private int gears;
    private boolean isManual;

    private int currentGear;

    public Car(String size, String name, int wheels, int door, int gears, boolean isManual) {
        super(size, name);
        this.wheels = wheels;
        this.door = door;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): Changed to " + this.currentGear + " gear");
    }

    public void changeVelocity(int speed, int direction){
        System.out.println("Car.changeVelocity(): Velocity " + speed + " direction " + direction);
        move(speed,direction);
    }

}
