package umbcs680.chess;


public interface State {
    void nextTurn(GameContext context); // Move to the next player's turn
    void gameOver(GameContext context);  // End the game
}
