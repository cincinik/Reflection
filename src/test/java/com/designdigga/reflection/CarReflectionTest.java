package com.designdigga.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;


public class CarReflectionTest {
    
    private static CarReflection instance;
    
   
    @BeforeClass
    public static void setUpClass() {
        instance = new CarReflection();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance=null;
    }
    
    @Before
    public void setUp() {
        System.out.println("TESTING METHOD:");
    }
    
    @After
    public void tearDown() {
        System.out.println("-------------------------------------");
    }

    @Test
    public void testShowParent() {
        String expected = "Vehicle";
        String result = instance.showParent();
        assertEquals(expected, result);
        System.out.println("Test returned " + result);
        
    }
    
    @Test
    public void testShowInterface() {
        String expected = "Automobile";
        String result = instance.showInterface();
        assertEquals(expected, result);
        System.out.println("Test returned " + result);
        
    }
    
    
    @Test
    public void testCreateObject() {
        try {
            Object expected = new Car(4, 4, 5, "verde", false, 230, "masina");
            Object result = instance.createObject();
            assertThat(result).isEqualToComparingFieldByField(expected);
            System.out.println("Test returned " + result);
        } catch (InstantiationException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testUseMyCar() {
        try {
            String expected = "Start engine and accelerate. Speed reaches 105";
            String result = instance.useMyCar();
            assertEquals(expected, result);
            System.out.println("Test returned " + result);
        } catch (InstantiationException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testPrivateField() {
        try {
            int expected = 7;
            int result = instance.privateField();
            assertEquals(expected, result);
            System.out.println("Test returned " + result);
        } catch (InstantiationException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testPrivateMethod() {
        try {
            int expected = 1;
            int result = instance.privateMethod();
            assertEquals(expected, result);
            System.out.println("Test returned " + result);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CarReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}