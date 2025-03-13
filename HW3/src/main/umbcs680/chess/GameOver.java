package umbcs680.chess;

public class GameOver implements State {
    @Override
    public void nextTurn(GameContext context) {
        System.out.println("The game is already over. No turns can be taken.");
    }

    @Override
    public void gameOver(GameContext context) {
        System.out.println("The game is already over.");
    }
}
