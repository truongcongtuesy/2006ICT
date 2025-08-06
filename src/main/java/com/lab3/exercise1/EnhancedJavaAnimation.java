package com.lab3.exercise1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EnhancedJavaAnimation extends Application {

    private StackPane root;
    private Scene scene;
    private AnimationTimer timer;
    private Circle ball;
    private DropShadow shadow;

    // Game settings
    private double dx = 3;
    private double dy = 3;
    private Color ballColor = Color.RED;
    private double ballSize = 10;
    private boolean shadowEnabled = false;

    private final double fieldWidth = 600;
    private final double fieldHeight = 400;

    // UI Controls for configuration
    private CheckBox shadowCheckBox;
    private ToggleGroup colorGroup;
    private RadioButton redRadio, greenRadio, blueRadio;
    private Label sizeLabel;
    private Slider sizeSlider;

    @Override
    public void start(Stage primaryStage) {
        root = new StackPane();
        scene = new Scene(root, fieldWidth, fieldHeight);
        
        // Initialize shadow effect
        shadow = new DropShadow();
        shadow.setColor(Color.GRAY);
        shadow.setOffsetX(3);
        shadow.setOffsetY(3);

        showMainScreen();

        primaryStage.setTitle("Enhanced JavaFX Animation Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showMainScreen() {
        VBox mainScreen = new VBox(20);
        mainScreen.setPadding(new Insets(30));
        mainScreen.setAlignment(Pos.CENTER);

        // Main Screen label
        Label mainLabel = new Label("Main Screen");
        mainLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Buttons
        Button startButton = new Button("Start Game");
        startButton.setPrefWidth(150);
        startButton.setStyle("-fx-font-size: 14px;");
        
        Button configButton = new Button("Configuration");
        configButton.setPrefWidth(150);
        configButton.setStyle("-fx-font-size: 14px;");
        
        Button exitButton = new Button("Exit");
        exitButton.setPrefWidth(150);
        exitButton.setStyle("-fx-font-size: 14px;");

        // Button actions
        startButton.setOnAction(e -> showGameScreen());
        configButton.setOnAction(e -> showConfigurationScreen());
        exitButton.setOnAction(e -> System.exit(0));

        mainScreen.getChildren().addAll(mainLabel, startButton, configButton, exitButton);
        root.getChildren().setAll(mainScreen);
    }

    private void showConfigurationScreen() {
        VBox configScreen = new VBox(20);
        configScreen.setPadding(new Insets(30));
        configScreen.setAlignment(Pos.CENTER);

        // Configuration label
        Label configLabel = new Label("Configuration");
        configLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Shadow checkbox
        shadowCheckBox = new CheckBox("Enable Shadow");
        shadowCheckBox.setSelected(shadowEnabled);
        shadowCheckBox.setOnAction(e -> shadowEnabled = shadowCheckBox.isSelected());

        // Color radio buttons
        Label colorLabel = new Label("Ball Color:");
        colorLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        colorGroup = new ToggleGroup();
        redRadio = new RadioButton("Red");
        greenRadio = new RadioButton("Green");
        blueRadio = new RadioButton("Blue");
        
        redRadio.setToggleGroup(colorGroup);
        greenRadio.setToggleGroup(colorGroup);
        blueRadio.setToggleGroup(colorGroup);
        
        // Set initial selection based on current color
        if (ballColor == Color.RED) redRadio.setSelected(true);
        else if (ballColor == Color.GREEN) greenRadio.setSelected(true);
        else if (ballColor == Color.BLUE) blueRadio.setSelected(true);
        
        // Color change listeners
        redRadio.setOnAction(e -> ballColor = Color.RED);
        greenRadio.setOnAction(e -> ballColor = Color.GREEN);
        blueRadio.setOnAction(e -> ballColor = Color.BLUE);

        HBox colorBox = new HBox(15);
        colorBox.setAlignment(Pos.CENTER);
        colorBox.getChildren().addAll(redRadio, greenRadio, blueRadio);

        // Ball size controls
        sizeLabel = new Label("Ball Size: " + (int)ballSize);
        sizeLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        sizeSlider = new Slider(5, 20, ballSize);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setMajorTickUnit(5);
        sizeSlider.setMinorTickCount(4);
        sizeSlider.setPrefWidth(200);
        
        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            ballSize = newValue.doubleValue();
            sizeLabel.setText("Ball Size: " + (int)ballSize);
        });

        // Back button
        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setStyle("-fx-font-size: 14px;");
        backButton.setOnAction(e -> showMainScreen());

        configScreen.getChildren().addAll(
            configLabel, 
            shadowCheckBox, 
            colorLabel, 
            colorBox, 
            sizeLabel, 
            sizeSlider, 
            backButton
        );
        
        root.getChildren().setAll(configScreen);
    }

    private void showGameScreen() {
        Pane gamePane = new Pane();

        // Create field border
        Rectangle field = new Rectangle(0, 0, fieldWidth, fieldHeight);
        field.setFill(Color.LIGHTBLUE);
        field.setStroke(Color.BLACK);
        field.setStrokeWidth(3);

        // Create ball with current settings
        ball = new Circle(ballSize, ballColor);
        ball.setCenterX(fieldWidth / 2);
        ball.setCenterY(fieldHeight / 2);
        
        // Apply shadow if enabled
        updateBallAppearance();

        // Game controls label
        Label controlsLabel = new Label("Controls: Arrow keys to change direction");
        controlsLabel.setLayoutX(10);
        controlsLabel.setLayoutY(fieldHeight - 25);
        controlsLabel.setStyle("-fx-font-size: 12px; -fx-background-color: white; -fx-padding: 3px;");

        Button backButton = new Button("Back to Main");
        backButton.setLayoutX(10);
        backButton.setLayoutY(10);
        backButton.setOnAction(e -> {
            if (timer != null) timer.stop();
            showMainScreen();
        });

        gamePane.getChildren().addAll(field, ball, backButton, controlsLabel);

        // Enhanced key controls
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                // Up arrow: Increase speed in Y direction (upward)
                dy = Math.max(dy - 1, -10); // Limit max speed
            } else if (e.getCode() == KeyCode.DOWN) {
                // Down arrow: Decrease speed in Y direction (downward)
                dy = Math.min(dy + 1, 10); // Limit max speed
            } else if (e.getCode() == KeyCode.LEFT) {
                // Left arrow: Decrease speed in X direction
                dx = Math.max(dx - 1, -10); // Limit max speed
            } else if (e.getCode() == KeyCode.RIGHT) {
                // Right arrow: Increase speed in X direction
                dx = Math.min(dx + 1, 10); // Limit max speed
            }
        });

        // Animation timer
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Update ball appearance in case settings changed
                updateBallAppearance();
                
                double nextX = ball.getCenterX() + dx;
                double nextY = ball.getCenterY() + dy;

                // Bounce off edges
                if (nextX - ball.getRadius() < 0 || nextX + ball.getRadius() > fieldWidth) {
                    dx = -dx;
                }
                if (nextY - ball.getRadius() < 0 || nextY + ball.getRadius() > fieldHeight) {
                    dy = -dy;
                }

                ball.setCenterX(ball.getCenterX() + dx);
                ball.setCenterY(ball.getCenterY() + dy);
            }
        };

        timer.start();
        root.getChildren().setAll(gamePane);
        gamePane.requestFocus(); // Ensure pane gets key input
    }
    
    private void updateBallAppearance() {
        if (ball != null) {
            ball.setFill(ballColor);
            ball.setRadius(ballSize);
            if (shadowEnabled) {
                ball.setEffect(shadow);
            } else {
                ball.setEffect(null);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
