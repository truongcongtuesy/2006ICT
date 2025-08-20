package com.lab4.exercise1.UI;

import com.lab4.exercise1.model.Game;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Game screen that displays the animated game
 * Handles user input and game rendering
 */
public class GameScreen extends ScreenWithGame {
    private Canvas canvas;
    private GraphicsContext gc;
    private AnimationTimer gameTimer;
    
    public GameScreen(Frame frame, Game game) {
        super(frame, game);
    }
    
    @Override
    public Parent createLayout() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(10);
        
        // Game title
        Label gameTitle = new Label("Enhanced JavaAnimation - Game Running");
        gameTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        // Canvas for game rendering
        canvas = new Canvas(600, 400);
        canvas.getStyleClass().add("game-field");
        canvas.setFocusTraversable(true); // Make canvas focusable
        gc = canvas.getGraphicsContext2D();
        
        // Control instructions with current speed display
        Label controlsLabel = new Label("Controls: Arrow Keys to adjust speed | Space to reset | ESC to return to main menu");
        controlsLabel.getStyleClass().add("game-controls-label");
        
        // Speed display
        Label speedLabel = new Label("Speed: X=" + String.format("%.1f", game.getDx()) + " Y=" + String.format("%.1f", game.getDy()));
        speedLabel.getStyleClass().add("speed-display");
        speedLabel.setId("speedDisplay");
        
        // Back button
        Button backButton = new Button("Back to Main");
        backButton.getStyleClass().add("back-button");
        backButton.setOnAction(e -> {
            stopGame();
            frame.showMainScreen();
        });
        
        layout.getChildren().addAll(gameTitle, canvas, controlsLabel, speedLabel, backButton);
        
        // Apply CSS styling
        applyStyles(layout);
        
        // Setup key handling for both layout and canvas
        layout.setFocusTraversable(true);
        canvas.setFocusTraversable(true);
        
        // Add key handlers to both layout and canvas for better responsiveness
        layout.setOnKeyPressed(this::handleKeyPress);
        canvas.setOnKeyPressed(this::handleKeyPress);
        
        // Ensure canvas gets focus when clicked
        canvas.setOnMouseClicked(e -> canvas.requestFocus());
        
        // Request focus initially
        canvas.requestFocus();
        
        // Start the game animation
        startGame();
        
        return layout;
    }
    
    @Override
    protected void handleGameLogic() {
        game.updateBallPosition();
    }
    
    @Override
    protected void updateDisplay() {
        renderGame();
    }
    
    private void startGame() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
        
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleGameLogic();
                updateDisplay();
            }
        };
        gameTimer.start();
    }
    
    private void stopGame() {
        if (gameTimer != null) {
            gameTimer.stop();
            gameTimer = null;
        }
    }
    
    private void renderGame() {
        // Clear canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Draw background gradient
        gc.setFill(Color.web("#87ceeb"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Draw border
        gc.setStroke(Color.web("#2c3e50"));
        gc.setLineWidth(4);
        gc.strokeRect(2, 2, canvas.getWidth() - 4, canvas.getHeight() - 4);
        
        // Draw shadow if enabled
        if (game.isShadowEnabled()) {
            gc.setFill(Color.gray(0.3, 0.5));
            gc.fillOval(game.getBallX() - game.getBallSize() + 3, 
                       game.getBallY() - game.getBallSize() + 3, 
                       game.getBallSize() * 2, 
                       game.getBallSize() * 2);
        }
        
        // Draw ball
        gc.setFill(game.getBallColor());
        gc.fillOval(game.getBallX() - game.getBallSize(), 
                   game.getBallY() - game.getBallSize(), 
                   game.getBallSize() * 2, 
                   game.getBallSize() * 2);
        
        // Draw ball highlight
        gc.setFill(Color.WHITE.deriveColor(0, 1, 1, 0.3));
        gc.fillOval(game.getBallX() - game.getBallSize() + 2, 
                   game.getBallY() - game.getBallSize() + 2, 
                   game.getBallSize(), 
                   game.getBallSize());
    }
    
    private void handleKeyPress(KeyEvent event) {
        boolean speedChanged = false;
        
        switch (event.getCode()) {
            case UP:
                game.adjustYSpeed(-0.5);
                speedChanged = true;
                System.out.println("UP pressed - Y speed: " + game.getDy());
                break;
            case DOWN:
                game.adjustYSpeed(0.5);
                speedChanged = true;
                System.out.println("DOWN pressed - Y speed: " + game.getDy());
                break;
            case LEFT:
                game.adjustXSpeed(-0.5);
                speedChanged = true;
                System.out.println("LEFT pressed - X speed: " + game.getDx());
                break;
            case RIGHT:
                game.adjustXSpeed(0.5);
                speedChanged = true;
                System.out.println("RIGHT pressed - X speed: " + game.getDx());
                break;
            case SPACE:
                game.resetBall();
                speedChanged = true;
                System.out.println("SPACE pressed - Ball reset");
                break;
            case ESCAPE:
                stopGame();
                frame.showMainScreen();
                break;
            default:
                break;
        }
        
        // Update speed display if speed changed
        if (speedChanged) {
            updateSpeedDisplay();
        }
        
        // Consume the event to prevent further processing
        event.consume();
    }
    
    private void updateSpeedDisplay() {
        // Find the speed display label and update it
        VBox layout = (VBox) canvas.getParent();
        layout.getChildren().stream()
            .filter(node -> "speedDisplay".equals(node.getId()))
            .findFirst()
            .ifPresent(node -> {
                Label speedLabel = (Label) node;
                speedLabel.setText("Speed: X=" + String.format("%.1f", game.getDx()) + 
                                 " Y=" + String.format("%.1f", game.getDy()));
            });
    }
}
