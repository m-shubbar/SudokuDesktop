package ca.shubbar.gamebox;

import java.io.IOException;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-02
 */

// Design by contract, anticipating IO Exceptions
public interface IStorage {
    void updateGameData(SudokuGame game) throws IOException;
    SudokuGame getGameData() throws IOException;
}
