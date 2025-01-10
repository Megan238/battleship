package cs3500.pa03.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.function.UnaryOperator;

public class FleetNumView extends VBox {
    private TextField SUBMARINE = new TextField();
    private TextField DESTROYER = new TextField();
    private TextField BATTLESHIP = new TextField();
    private TextField CARRIER = new TextField();
    private Button playButton = new Button("Play");
    FleetNumView() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        HBox setShipNumber = new HBox();
        setShipNumber.setSpacing(10);
        setShipNumber.getChildren().add(new Label("Set Ship Number: "));
        SUBMARINE.setTextFormatter(textFormatter);
        DESTROYER.setTextFormatter(textFormatter);
        BATTLESHIP.setTextFormatter(textFormatter);
        CARRIER.setTextFormatter(textFormatter);
        setShipNumber.getChildren().add(SUBMARINE);
        setShipNumber.getChildren().add(DESTROYER);
        setShipNumber.getChildren().add(BATTLESHIP);
        setShipNumber.getChildren().add(CARRIER);
        this.getChildren().add(playButton);
        playButton.setOnAction(event -> {});
    }

}
