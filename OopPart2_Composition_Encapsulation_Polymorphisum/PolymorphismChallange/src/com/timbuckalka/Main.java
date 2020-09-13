package com.timbuckalka;

class Car{
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;
    private boolean isEngineOn=false;
    private int speed =0;


    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.name = name;
    }

    public void startEngine(){
        System.out.println(this.name + "`s Engine is on!");
        this.isEngineOn = true;
    }

    public void accelerate(){
        if(isEngineOn) {
            this.speed += 2;
            System.out.println("The " + getClass().getSimpleName() +" is moving with " + this.speed + " km/h!");
        }else{
            System.out.println("Start"+" " + this.name + "`s engine first");
        }
    }
    public void brake(){
        if(this.speed>0) {
            this.speed -= 2;
            System.out.println("The " + this.name + " slowed down to: " + this.speed + "km/h!");
        }
    }

    public int getCylinders() {
        return cylinders;
    }


    public String getName() {
        return name;
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}

class Mercedes extends Car{
    private String color;
    private int topSpeed;

    public Mercedes(int cylinders, String name, String color, int topSpeed) {
        super(cylinders, name);
        this.color = color;
        this.topSpeed = topSpeed;
    }

    @Override
    public void accelerate() {
        if(!super.isEngineOn()){
            System.out.println("Start"+" " + super.getName() + "`s engine first");
        }else if(super.getSpeed()< this.topSpeed) {
            super.setSpeed(super.getSpeed()+10);
            System.out.println("The " + super.getName() +" is moving with " + super.getSpeed() + " km/h!");
        }else{
            System.out.println(super.getName() + "`s max Speed reached");
        }
    }

    public String getColor() {
        return color;
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}

class Tracktor extends Car{

    public Tracktor(int cylinders, String name) {
        super(2, name);
    }

    @Override
    public void brake() {
        super.setSpeed(0);
        System.out.println("Tracktor stoped!");
    }
}

class Trabant extends Car{
    private String color;

    public Trabant(int cylinders, String name, String color) {
        super(cylinders, name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


public class Main {

    public static void main(String[] args) {
        // We are going to go back to the car analogy.
        // Create a base class called Car
        // It should have a few fields that would be appropriate for a generice car calss.
        // engine, cylinders, wheels, etc.
        // Constructor should initialize cylinders (number of) and name, and set wheels to 4
        // and engine to true. Cylinders and names would be passed parameters.
        //
        // Create appropriate getters
        //
        // Create some methods like startEngine, accelerate, and brake
        //
        // show a message for each in the base class
        // Now create 3 sub classes for your favorite vehicles.
        // Override the appropriate methods to demonstrate polymorphism in use.
        // put all classes in the one java file (this one).

        Mercedes mercedes = new Mercedes(8,"Mercedess", "Blue",50);
        System.out.println("A " + mercedes.getColor() + " " + mercedes.getName() + " with " + mercedes.getCylinders() + " cylinders was added to your garage! \n"
                + "Top speed is: " + mercedes.getTopSpeed());

        Tracktor tracktor = new Tracktor(2,"Tracktor");
        System.out.println("A " + tracktor.getName() + " with " + tracktor.getCylinders() + " cylinders was added to your garage!");

        Trabant trabant = new Trabant(4,"Trabant", "blue");
        System.out.println("A " + trabant.getColor() + " " + trabant.getName() + " with " + trabant.getCylinders() + " cylinders was added to your garage!");

        mercedes.startEngine();
        tracktor.accelerate();
        trabant.startEngine();
        tracktor.startEngine();
        mercedes.accelerate();
        mercedes.accelerate();
        mercedes.accelerate();
        mercedes.accelerate();
        mercedes.accelerate();
        mercedes.accelerate();
        trabant.accelerate();
        trabant.accelerate();
        trabant.accelerate();
        tracktor.accelerate();
        tracktor.accelerate();
        tracktor.accelerate();
        tracktor.accelerate();
        tracktor.accelerate();
        tracktor.brake();
        mercedes.brake();
        mercedes.brake();
        trabant.brake();
    }
}
