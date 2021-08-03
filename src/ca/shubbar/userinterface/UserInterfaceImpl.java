package ca.shubbar.userinterface;

import ca.shubbar.gamebox.Coordinates;
import ca.shubbar.gamebox.SudokuGame;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-02
 */
public class UserInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent> {

    private final Stage stage;
    private final Group root;

    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;
    private IUserInterfaceContract.EventListener listener;
    private static final double WINDOW_X = 732;
    private static final double WINDOW_Y = 668;
    private static final double BOARD_PADDING = 50;
    private static final double BOARD_X_AND_Y = 576;

    private static final Color WINDOW_BG_COLOR = Color.rgb(0, 150, 136);
    private static final Color WINDOW_BOARD_COLOR = Color.rgb(224, 242, 241);

    private static final String SUDOKU = "Sudoku";

    public UserInterfaceImpl(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        this.textFieldCoordinates = new HashMap<>();
        initializeUserInterface();
    }

    private void initializeUserInterface() {
        drawBackground(root);
        drawTitle(root);
        drawSudokuBoard(root);
        drawTextFields(root);
        drawGridLines(root);
        stage.show();
    }

    @Override
    public void setListener(IUserInterfaceContract.EventListener listener) {

    }

    @Override
    public void updateSquare(int x, int y, int input) {

    }

    @Override
    public void updateBoard(SudokuGame game) {

    }

    @Override
    public void showDialog(String message) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void handle(KeyEvent keyEvent) {

    }
}
