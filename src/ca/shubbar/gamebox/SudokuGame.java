package ca.shubbar.gamebox;

import java.io.Serializable;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-02
 */

// We want to read/write this game file to OS
public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;
    public final static int GRID_BOUNDARY = 9;

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
