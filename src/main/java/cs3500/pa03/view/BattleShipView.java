package cs3500.pa03.view;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.enumuation.ShipType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface BattleShipView {
    int[] askSize(String prompt) throws IOException;
    Map<ShipType, Integer> askFleet(String prompt) throws IOException;
    List<Coord> takeShot(String prompt, int shipCount) throws IOException;
    void presentPrompt(String prompt);

}
