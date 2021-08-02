package ca.shubbar.gamebox;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-02
 */
public class SudokuGame {
    private final GameState gameState;
    private final int[][] gridState;
    public final static GRID_BOUNDARY = 9;

    public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        // Protecting the actual value from being messed with
        return SudokuUtilities.copyToNewArray(gridState);
    }
}
