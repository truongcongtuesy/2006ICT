package com.lab4.exercise1.UI;

import com.lab4.exercise1.model.Game;
import javafx.scene.Parent;

/**
 * Abstract Screen class following Template Method Pattern
 * Provides common functionality for all screens
 */
public abstract class Screen {
    protected Frame frame;
    protected Game game;
    
    public Screen(Frame frame, Game game) {
        this.frame = frame;
        this.game = game;
    }
    
    /**
     * Create and return the UI layout for this screen
     */
    public abstract Parent createLayout();
    
    /**
     * Apply CSS styling to the layout
     */
    protected void applyStyles(Parent layout) {
        String css = getClass().getResource("/styles.css").toExternalForm();
        layout.getStylesheets().add(css);
    }
}
