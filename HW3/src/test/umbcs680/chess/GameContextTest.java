package umbcs680.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameContextTest {
    private GameContext gameContext;

    @BeforeEach
    void setUp() {
        gameContext = new GameContext(); // Initialize a new game context before each test
    }

    @Test
    void setState() {
        // Create a new state (BlackTurn)
        State blackTurn = new BlackTurn();
        gameContext.setState(blackTurn); // Set the current state to BlackTurn

        // Assert that the current state is now BlackTurn
        assertTrue(gameContext.getState() instanceof BlackTurn);
    }

    @Test
    void getState() {
        // Initially, the state should be WhiteTurn
        assertTrue(gameContext.getState() instanceof WhiteTurn);
    }

    @Test
    void nextTurn() {
        // Transition from White's turn to Black's turn
        gameContext.nextTurn();
        assertTrue(gameContext.getState() instanceof BlackTurn); // Check that it is now Black's turn

        // Transition from Black's turn back to White's turn
        gameContext.nextTurn();
        assertTrue(gameContext.getState() instanceof WhiteTurn); // Check that it is now White's turn
    }

    @Test
    void gameOver() {
        // End the game from the current state (White's turn)
        gameContext.gameOver();
        assertTrue(gameContext.getState() instanceof GameOver); // Verify that the state is now GameOver
    }
}
