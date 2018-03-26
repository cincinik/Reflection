/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designdigga.reflection;

/**
 *
 * @author envy
 */
public class Car extends Vehicle implements Automobile {
    
    private int gear;
    private int seats;
    private int speed;
    private static String brand;
    public String color;
    public boolean isManual;

    public Car(int gear, int seats, int speed, String color, boolean isManual, int maxSpeed, String name) {
        super(maxSpeed, name);
        this.gear = gear;
        this.seats = seats;
        this.speed = speed;
        this.color = color;
        this.isManual = isManual;
    }

    public String start() {
        gear = 1;
        speed = 5;
        String start = "Start engine and accelerate.";
        return (start);
        
    }

    public String stop() {
        speed = 0;
        return("Apply break until car stops and stop engine.");
    }

    @Override
    public int accelerate(int moreSpeed ) {
        this.speed += moreSpeed;
        return speed;
    }

    @Override
    public int slowDown(int lessSpeed) {
        this.speed-=lessSpeed;
        System.out.println("Car method slowDown() called: Slowing down! Speed reaches " + speed);
        return speed;
    }
    
    private int changeGear(){
        if(speed>0 && speed<15){
            gear = 1;
        } else if(speed >=15 && speed<30){
            gear = 2;
        } else if (speed >=30 && speed<50){
            gear = 3;
        } else if (speed >=50 && speed<100){
            gear = 4;
        } else if (speed>=100 && speed<150){
            gear = 5;
        } else if(speed>=150 && speed<=super.getSpeed()){
            gear = 6;
        } else {
            System.out.println("Not valid speed!");
        }
        return gear;
    }  
}
