package cs3500.pa03.view;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.enumuation.ShipType;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

public class BattleShipViewWeb extends Application implements BattleShipView {
    Stage stage;
    public int[] askSize(String prompt){
        // present board size view
        // board size view being click next
        // return board size from board size view
        BoardSizeView boardSizeView = new BoardSizeView();
        Scene scene = new Scene(boardSizeView, 400, 200);
        stage.setScene(scene);
        stage.show();
        return boardSizeView.getBoardSize();
    }

    public void test(String prompt){
        // present board size view
        // board size view being click next
        // return board size from board size view
        BoardSizeView boardSizeView = new BoardSizeView();
        Scene scene = new Scene(boardSizeView, 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public Map<ShipType, Integer> askFleet(String prompt) throws IOException {
        return Map.of();
    }

    @Override
    public List<Coord> takeShot(String prompt, int shipCount) throws IOException {
        return List.of();
    }

    @Override
    public void presentPrompt(String prompt) {

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        BoardSizeView boardSizeView = new BoardSizeView();
        VBox v = new VBox();
        Scene scene = new Scene(boardSizeView, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
