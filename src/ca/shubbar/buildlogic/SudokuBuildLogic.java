package ca.shubbar.buildlogic;

import ca.shubbar.computationlogic.GameLogic;
import ca.shubbar.gamebox.IStorage;
import ca.shubbar.gamebox.SudokuGame;
import ca.shubbar.persistence.LocalStorageImpl;
import ca.shubbar.userinterface.IUserInterfaceContract;
import ca.shubbar.userinterface.logic.ControlLogic;

import java.io.IOException;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-07
 */
public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
