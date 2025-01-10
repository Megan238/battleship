package cs3500.pa03.controller;

import cs3500.pa03.model.*;
import cs3500.pa03.view.BattleShipView;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ManualPlayerController {
    private final BattleShipView view;

    public ManualPlayerController(BattleShipView view) {
        this.view = view;
    }
    public List<Coord> handlePlayerTakeShort(int remainShip, boolean firstTime)  {
        List<Coord> userShorts;
        try {
            if (firstTime) {
                userShorts = this.view.takeShot("Please enter "
                        + remainShip + " shorts :\n", remainShip);
            } else {
                userShorts = this.view.takeShot("the Coordinates is "
                                + "not valid, Please enter again :\n",
                        remainShip);
            }
        } catch (IOException e) {
            this.view.presentPrompt("Meet unhandled situation : " + e.getMessage());
            return this.handlePlayerTakeShort(remainShip, true);
        }
        return userShorts;
    }
    public void presentPrompt(String prompt)  {
        this.view.presentPrompt(prompt);
    }
}

