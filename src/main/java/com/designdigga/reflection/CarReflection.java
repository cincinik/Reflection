/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designdigga.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author envy
 */
public class CarReflection {
    
    
    public static Class reflectClass = Car.class;
    
    public static String showParent(){
        String parent=reflectClass.getSuperclass().getSimpleName();
        return parent;
    }

    // Inspect Interfaces of Car
    public static String showInterface(){
        String inter="";
        Class[] interfaces = reflectClass.getInterfaces();
        for(Class interf: interfaces){
            inter+=interf.getSimpleName();
        }
        return inter;
    }
    
    // Inspect methods of Car
    public static String showMethods (){
        Method [] carMethods = reflectClass.getMethods();
         String[] methods = new String[carMethods.length];        
            for(int i=0; i<carMethods.length; i++){
                methods[i]=((carMethods[i].getReturnType()).toString() +" "+ carMethods[i].getName() + Arrays.toString(carMethods[i].getParameterTypes()) );
            }
            System.out.println(Arrays.toString(methods));
        return Arrays.toString(methods);
    }
        
    //Create a Car object accessing the Constructor with parameters
    public static Car createObject() throws InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Constructor <Car> construct; 
        construct = reflectClass.getConstructor(int.class, int.class, int.class, String.class, boolean.class, int.class, String.class);
        Car myCar = construct.newInstance(4, 4, 5, "verde", false, 230, "masina");
        return myCar; 
    }
    
    //Accessing some of Car's public methods
    public static String useMyCar() throws InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String use = createObject().start() + " Speed reaches " + createObject().accelerate(100);
        System.out.println(use);
        return use;
    }
    
    //Accesing and modifying a private field
    public static int privateField() throws InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
        Car bigCar=createObject();
        Field privateField = null;
        privateField = Car.class.getDeclaredField("seats");
        privateField.setAccessible(true);
        privateField.set(bigCar,7);
        return (Integer)privateField.get(bigCar);

    }
    
    //Accesing a private method
    public static int privateMethod() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String methodName = "changeGear";
        Method privmet = Car.class.getDeclaredMethod(methodName, null);
        privmet.setAccessible(true);
        Integer privateReturnValue = (Integer)privmet.invoke(createObject(), null);
        return privateReturnValue;
    }
    
}
