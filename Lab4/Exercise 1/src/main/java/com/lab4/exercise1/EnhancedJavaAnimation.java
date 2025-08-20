package com.lab4.exercise1;

import com.lab4.exercise1.UI.*;
import com.lab4.exercise1.model.Game;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Main application class implementing Frame interface
 * Following Dependency Inversion Principle
 */
public class EnhancedJavaAnimation extends Application implements Frame {
    private Stage primaryStage;
    private Scene scene;
    private Game game;
    
    // Screen instances
    private MainScreen mainScreen;
    private ConfigurationScreen configScreen;
    private GameScreen gameScreen;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        // Initialize game model
        game = new Game(600, 400);
        
        // Initialize screens
        mainScreen = new MainScreen(this, game);
        configScreen = new ConfigurationScreen(this, game);
        gameScreen = new GameScreen(this, game);
        
        // Setup initial scene
        scene = new Scene(mainScreen.createLayout(), 800, 600);
        
        // Configure stage
        primaryStage.setTitle("Enhanced JavaAnimation - Lab 4");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            exitApplication();
        });
        
        primaryStage.show();
    }
    
    @Override
    public void showMainScreen() {
        Platform.runLater(() -> {
            scene.setRoot(mainScreen.createLayout());
        });
    }
    
    @Override
    public void showConfigurationScreen() {
        Platform.runLater(() -> {
            scene.setRoot(configScreen.createLayout());
        });
    }
    
    @Override
    public void showGameScreen() {
        Platform.runLater(() -> {
            scene.setRoot(gameScreen.createLayout());
        });
    }
    
    @Override
    public void exitApplication() {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Exit Confirmation");
        exitAlert.setHeaderText("Are you sure you want to exit?");
        exitAlert.setContentText("Any unsaved progress will be lost.");
        
        exitAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
