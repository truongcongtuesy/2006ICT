package com.lab4.exercise1.UI;

/**
 * Frame interface to decouple Main from individual screen implementations
 * Following Dependency Inversion Principle
 */
public interface Frame {
    /**
     * Show main screen
     */
    void showMainScreen();
    
    /**
     * Show configuration screen
     */
    void showConfigurationScreen();
    
    /**
     * Show game screen
     */
    void showGameScreen();
    
    /**
     * Exit the application with confirmation
     */
    void exitApplication();
}
