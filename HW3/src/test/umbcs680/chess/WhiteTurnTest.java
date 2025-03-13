package umbcs680.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteTurnTest {
    private GameContext gameContext;
    private WhiteTurn whiteTurn;

    @BeforeEach
    void setUp() {
        gameContext = new GameContext(); // Initialize a new game context
        whiteTurn = new WhiteTurn(); // Create an instance of WhiteTurn
        gameContext.setState(whiteTurn); // Set the current state to WhiteTurn
    }

    @Test
    void nextTurn() {
        whiteTurn.nextTurn(gameContext); // Call nextTurn on WhiteTurn
        assertTrue(gameContext.getState() instanceof BlackTurn); // Verify transition to BlackTurn
    }

    @Test
    void gameOver() {
        whiteTurn.gameOver(gameContext); // Call gameOver on WhiteTurn
        assertTrue(gameContext.getState() instanceof GameOver); // Verify transition to GameOver state
    }
}
