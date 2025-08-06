package com.lab2.exercise2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Exercise 2: JavaFX Demo Application
 * Simple JavaFX application with user interaction
 */
public class HelloWorldApp extends Application {
    
    private Label welcomeLabel;
    private TextField nameField;
    private Button greetButton;
    private Label responseLabel;
    
    @Override
    public void start(Stage primaryStage) {
        // Initialize components
        welcomeLabel = new Label("Welcome to JavaFX Demo!");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setMaxWidth(200);
        
        greetButton = new Button("Say Hello");
        greetButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        
        responseLabel = new Label("");
        responseLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #2196F3;");
        
        // Set up event handling
        greetButton.setOnAction(event -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                responseLabel.setText("Please enter your name!");
                responseLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #F44336;");
            } else {
                responseLabel.setText("Hello, " + name + "! Welcome to Lab 2!");
                responseLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #4CAF50;");
            }
        });
        
        // Handle Enter key press in text field
        nameField.setOnAction(event -> greetButton.fire());
        
        // Create layout
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.getChildren().addAll(welcomeLabel, nameField, greetButton, responseLabel);
        root.setStyle("-fx-background-color: #f5f5f5;");
        
        // Create and configure scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Lab 2 - JavaFX Demo Application");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        // Focus on name field
        nameField.requestFocus();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
