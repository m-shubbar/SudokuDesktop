package ca.shubbar.userinterface.logic;

import ca.shubbar.constants.GameState;
import ca.shubbar.constants.Messages;
import ca.shubbar.gamebox.IStorage;
import ca.shubbar.gamebox.SudokuGame;
import ca.shubbar.userinterface.IUserInterfaceContract;

import java.io.IOException;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-04
 */
public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;
    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;
            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );
            storage.updateGameData(gameData);

            view.updateSquare(x, y, input);

            if(gameData.getGameState() == GameState.COMPLETE) {
                view.showDialog(Messages.GAME_COMPLETE);
            }
        } catch(IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try{
            storage.getGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());

        } catch(IOException e) {
            view.showError(Messages.ERROR);
        }
    }
}
