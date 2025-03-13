package umbcs680.chess;

public class GameContext {
    private State state; // Current state of the game

    public GameContext() {
        state = new WhiteTurn(); // Initialize with White's turn
    }

    public void setState(State state) {
        this.state = state; // Change the current state
    }

    public State getState() { // Add this method to get the current state
        return state;
    }

    public void nextTurn() {
        state.nextTurn(this); // Call nextTurn on the current state
    }

    public void gameOver() {
        state.gameOver(this); // Call gameOver on the current state
    }
}
