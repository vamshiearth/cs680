package umbcs680.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverTest {
    private GameContext gameContext;
    private GameOver gameOverState;

    @BeforeEach
    void setUp() {
        gameContext = new GameContext(); // Initialize a new game context
        gameOverState = new GameOver();   // Create an instance of GameOver
        gameContext.setState(gameOverState); // Set the current state to GameOver
    }

    @Test
    void nextTurn() {
        gameOverState.nextTurn(gameContext); // Attempt to go to the next turn
        assertTrue(gameContext.getState() instanceof GameOver); // Ensure it stays in GameOver state
    }

    @Test
    void gameOver() {
        gameOverState.gameOver(gameContext); // Call gameOver on GameOver
        assertTrue(gameContext.getState() instanceof GameOver); // Ensure it stays in GameOver state
    }
}
