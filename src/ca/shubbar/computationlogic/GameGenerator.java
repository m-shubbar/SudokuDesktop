package ca.shubbar.computationlogic;

import ca.shubbar.gamebox.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ca.shubbar.gamebox.SudokuGame.GRID_BOUNDARY;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-04
 */
public class GameGenerator {
    public static int[][] getNewGameGrid() {
        return unsolvedGame(getSolvedGame());
    }

    private static int[][] unsolvedGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solvableArray = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        while(solvable == false) {
            SudokuUtilities.copySudokuArrayValue(solvedGame, solvableArray);

            int index = 0;
            // remove 40 values
            while(index < 40) {
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);

                if(solvedGame[xCoordinate][yCoordinate] != 0) {
                    solvableArray[xCoordinate][yCoordinate] = 0;
                    index++;
                }
            }

            int[][] toBeSolved = new int [GRID_BOUNDARY][GRID_BOUNDARY];

            SudokuUtilities.copySudokuArrayValue(solvableArray, toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);
        }

        return solvableArray;
    }

    private static int[][] getSolvedGame() {
        // Algorithm using simple steps to generate a new Sudoku puzzle
        Random random = new Random(System.currentTimeMillis());
        int[][] newGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        for(int value = 1; value <= GRID_BOUNDARY; value++) {
            int allocations = 0;
            int interrupts = 0;
            List<Coordinates> allocTracker = new ArrayList<>();

            int attempts = 0;

            while(allocations < GRID_BOUNDARY) {
                if(interrupts > 200 ) {
                    allocTracker.forEach(coord -> {
                        newGrid[coord.getX()][coord.getY()] = 0;
                    });

                    interrupts = 0;
                    allocations = 0;
                    allocTracker.clear();
                    attempts++;
                }

                // If we still stuck, nuke everything
                if(attempts > 500) {
                    clearArray(newGrid);
                    attempts = 0;
                    value = 1;
                }
            }

            int xCoordinate = random.nextInt(GRID_BOUNDARY);
            int yCoordinate = random.nextInt(GRID_BOUNDARY);

            if(newGrid[xCoordinate][yCoordinate] == 0) {
                newGrid[xCoordinate][yCoordinate] = value;

                if(GameLogic.sudokuIsValid(newGrid)) {
                    newGrid[xCoordinate][yCoordinate] = 0;
                    interrupts++;
                } else {
                    allocTracker.add(new Coordinates(xCoordinate, yCoordinate));
                    allocations++;
                }
            }
        }
        return newGrid;
    }

    private static void clearArray(int[][] newGrid) {
        for(int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
            for(int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++){
                newGrid[xIndex][yIndex] = 0;
            }
        }
    }
}
