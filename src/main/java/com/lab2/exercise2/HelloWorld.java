package com.lab2.exercise2;

/**
 * Exercise 2: Simple Hello World Java Application
 * This is a basic Java application that demonstrates console output.
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Welcome to Lab 2 - Java Development");
        System.out.println("This project replaces IntelliJ IDEA with VS Code");
        
        // Display system information
        System.out.println("\n--- System Information ---");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("User Name: " + System.getProperty("user.name"));
    }
}
