package umbcs680.chess;


public class BlackTurn implements State {
    @Override
    public void nextTurn(GameContext context) {
        System.out.println("It's White's turn.");
        context.setState(new WhiteTurn()); // Transition to White's turn
    }

    @Override
    public void gameOver(GameContext context) {
        System.out.println("Game Over! Black has won.");
        context.setState(new GameOver()); // Transition to Game Over state
    }
}
