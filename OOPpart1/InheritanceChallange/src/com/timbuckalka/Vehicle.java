package com.timbuckalka;

public class Vehicle {

    private String size;
    private String name;

    private int currentVelocity;
    private int currentDirection;
    public Vehicle(String size, String name) {
        this.size = size;
        this.name = name;

        this.currentDirection = 0;
        this.currentVelocity = 0;
    }

    public void steer(int direction){
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + "degrees");
    }

    public void move(int velocity, int direction){
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection + " degrees");
    }

    public void stop(){
        this.currentVelocity = 0;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
