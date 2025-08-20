package com.lab4.exercise1.model;

import javafx.scene.paint.Color;

/**
 * Game model class manages all game data and logic
 * Following Single Responsibility Principle
 */
public class Game {
    // Game physics
    private double dx = 3;
    private double dy = 3;
    
    // Ball properties
    private Color ballColor = Color.RED;
    private double ballSize = 10;
    private boolean shadowEnabled = false;
    
    // Ball position
    private double ballX;
    private double ballY;
    
    // Field dimensions
    private final double fieldWidth;
    private final double fieldHeight;
    
    public Game(double fieldWidth, double fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.ballX = fieldWidth / 2;
        this.ballY = fieldHeight / 2;
    }
    
    /**
     * Update ball position based on current velocity
     */
    public void updateBallPosition() {
        double nextX = ballX + dx;
        double nextY = ballY + dy;
        
        // Bounce off edges
        if (nextX - ballSize < 0 || nextX + ballSize > fieldWidth) {
            dx = -dx;
        }
        if (nextY - ballSize < 0 || nextY + ballSize > fieldHeight) {
            dy = -dy;
        }
        
        ballX += dx;
        ballY += dy;
    }
    
    /**
     * Adjust X direction speed
     */
    public void adjustXSpeed(int delta) {
        dx = Math.max(Math.min(dx + delta, 10), -10);
    }
    
    /**
     * Adjust Y direction speed
     */
    public void adjustYSpeed(int delta) {
        dy = Math.max(Math.min(dy + delta, 10), -10);
    }
    
    /**
     * Reset ball to center position
     */
    public void resetBall() {
        ballX = fieldWidth / 2;
        ballY = fieldHeight / 2;
        dx = 3;
        dy = 3;
    }
    
    // Getters and setters
    public double getBallX() { return ballX; }
    public double getBallY() { return ballY; }
    public double getDx() { return dx; }
    public double getDy() { return dy; }
    
    public Color getBallColor() { return ballColor; }
    public void setBallColor(Color ballColor) { this.ballColor = ballColor; }
    
    public double getBallSize() { return ballSize; }
    public void setBallSize(double ballSize) { this.ballSize = ballSize; }
    
    public boolean isShadowEnabled() { return shadowEnabled; }
    public void setShadowEnabled(boolean shadowEnabled) { this.shadowEnabled = shadowEnabled; }
    
    public double getFieldWidth() { return fieldWidth; }
    public double getFieldHeight() { return fieldHeight; }
}
