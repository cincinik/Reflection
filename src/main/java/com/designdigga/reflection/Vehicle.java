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
public abstract class Vehicle {
    
    private int maxSpeed;
    private String name;

    public Vehicle(int maxSpeed, String name) {
        this.maxSpeed = maxSpeed;
        this.name = name;
    }
    
    public abstract int accelerate(int moreSpeed);
    
    public abstract int slowDown(int lessSpeed);

    public int getSpeed() {
        return maxSpeed;
    }

    public String getName() {
        return name;
    }
    
    
    
    
    
}
