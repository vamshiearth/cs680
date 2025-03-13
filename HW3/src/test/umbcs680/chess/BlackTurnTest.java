package umbcs680.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackTurnTest {
    private GameContext gameContext;
    private BlackTurn blackTurn;

    @BeforeEach
    void setUp() {
        gameContext = new GameContext(); // Initialize a new game context
        blackTurn = new BlackTurn(); // Create an instance of BlackTurn
        gameContext.setState(blackTurn); // Set the current state to BlackTurn
    }

    @Test
    void nextTurn() {
        blackTurn.nextTurn(gameContext); // Call nextTurn on BlackTurn
        assertTrue(gameContext.getState() instanceof WhiteTurn); // Verify transition to WhiteTurn
    }

    @Test
    void gameOver() {
        blackTurn.gameOver(gameContext); // Call gameOver on BlackTurn
        assertTrue(gameContext.getState() instanceof GameOver); // Verify transition to GameOver state
    }
}
