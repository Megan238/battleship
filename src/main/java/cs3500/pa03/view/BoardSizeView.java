package cs3500.pa03.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.function.UnaryOperator;

public class BoardSizeView extends VBox {
    private TextField height = new TextField();
    private TextField width = new TextField();
    private Button nextButton = new Button("Next->");
    private Boolean nextClicked = false;

    BoardSizeView() {
        this.setSpacing(10);
        this.getChildren().add(new Label("Welcome to BattleShip Game , Setting Page"));
        HBox setBoardSize = new HBox();
        setBoardSize.setSpacing(10);
        setBoardSize.getChildren().add(new Label("Set Board Size: "));
        height.setPromptText("Height");
        width.setPromptText("Width");
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        height.setTextFormatter(textFormatter);
//        width.setTextFormatter(textFormatter);
        setBoardSize.getChildren().add(height);
        setBoardSize.getChildren().add(width);
        this.getChildren().add(setBoardSize);
        nextButton.setOnAction(event -> next());
        this.getChildren().add(nextButton);
    }
    private void next() {
        nextClicked = true;
    }
    public int[] getBoardSize() {
        // Wait until "Next" is clicked and then return the board size
        while (!nextClicked) {
            try {
                // Sleep briefly to avoid locking the UI thread
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return new int[]{Integer.parseInt(height.getText()), Integer.parseInt(width.getText())};
    }

}
