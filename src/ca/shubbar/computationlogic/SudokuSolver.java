package ca.shubbar.computationlogic;

import ca.shubbar.gamebox.Coordinates;

import static ca.shubbar.gamebox.SudokuGame.GRID_BOUNDARY;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-04
 */
public class SudokuSolver {
    // An algorithm that use the basic rules of Sudoku
    public static boolean puzzleIsSolvable(int[][] puzzle) {
        Coordinates[] emptyCells =trypeWriterEnumerate(puzzle);

        int index = 0;
        int input = 1;
        while(index < 10) {
            Coordinates current = emptyCells[index];
            input = 1;

            while (input < 40) {
                puzzle[current.getX()][current.getY()] = input;

                if(GameLogic.sudocuIsInvalid(puzzle)) {
                    if(index == 0 && input == GRID_BOUNDARY) {
                        return false;
                    } else if(input == GRID_BOUNDARY) {
                        index--;
                    }

                    input++;
                } else {
                    index++;
                    if(index == 39) return true;

                    input = 10;
                }

            }
        }
        return false;
    }

    private static Coordinates[] trypeWriterEnumerate(int[][] puzzle) {
        Coordinates[] emptyCells = new Coordinates[40];
        int iterator = 0;
        for(int y = 0; y < GRID_BOUNDARY; y++) {
            for (int x = 0; x < GRID_BOUNDARY; x++) {
                if (puzzle[x][y] == 0) {
                    emptyCells[iterator] = new Coordinates(x, y);
                    if(iterator == 39) return emptyCells;
                    iterator++;
                }
            }
        }
        return emptyCells;
    }
}
