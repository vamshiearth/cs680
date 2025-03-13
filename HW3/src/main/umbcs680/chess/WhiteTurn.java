package umbcs680.chess;


public class WhiteTurn implements State {
    @Override
    public void nextTurn(GameContext context) {
        System.out.println("It's Black's turn.");
        context.setState(new BlackTurn()); // Transition to Black's turn
    }

    @Override
    public void gameOver(GameContext context) {
        System.out.println("Game Over! White has won.");
        context.setState(new GameOver()); // Transition to Game Over state
    }
}
