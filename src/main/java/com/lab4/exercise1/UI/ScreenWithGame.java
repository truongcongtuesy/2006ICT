package com.lab4.exercise1.UI;

import com.lab4.exercise1.model.Game;

/**
 * Abstract class for screens that need access to game state
 * Extending Screen class for screens that interact with game
 */
public abstract class ScreenWithGame extends Screen {
    
    public ScreenWithGame(Frame frame, Game game) {
        super(frame, game);
    }
    
    /**
     * Handle game-specific logic
     */
    protected abstract void handleGameLogic();
    
    /**
     * Update game display based on current game state
     */
    protected abstract void updateDisplay();
}
