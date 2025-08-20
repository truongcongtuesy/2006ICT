package com.lab4.exercise1.UI;

import com.lab4.exercise1.model.Game;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Main screen of the application
 * Provides navigation to other screens
 */
public class MainScreen extends Screen {
    
    public MainScreen(Frame frame, Game game) {
        super(frame, game);
    }
    
    @Override
    public Parent createLayout() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(25);
        layout.getStyleClass().add("main-screen");
        
        // Title
        Label title = new Label("Enhanced JavaAnimation");
        title.getStyleClass().add("main-title");
        
        // Start Game Button
        Button startButton = new Button("Start Game");
        startButton.getStyleClass().add("main-button");
        startButton.setOnAction(e -> frame.showGameScreen());
        
        // Configuration Button
        Button configButton = new Button("Configuration");
        configButton.getStyleClass().addAll("main-button", "config-button");
        configButton.setOnAction(e -> frame.showConfigurationScreen());
        
        // Exit Button
        Button exitButton = new Button("Exit");
        exitButton.getStyleClass().addAll("main-button", "exit-button");
        exitButton.setOnAction(e -> frame.exitApplication());
        
        layout.getChildren().addAll(title, startButton, configButton, exitButton);
        
        // Apply CSS styling
        applyStyles(layout);
        
        return layout;
    }
}
