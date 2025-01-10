package cs3500.pa03.model;

import cs3500.pa03.controller.ManualPlayerController;
import cs3500.pa03.model.enumuation.GameResult;
import cs3500.pa03.view.BattleShipView;
import cs3500.pa03.view.BattleShipViewCommandLine;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * represent a manual player, need a person to interact with
 */
public class ManualPlayer extends AbstractPlayer {
  private ManualPlayerController controller;
  /**
   * @param controller is the controller for this player
   * @param r is the random number to place ship.
   * @param remainShip is the remain ship this player have
   * @param board is the board this player can see
   */
  public ManualPlayer(ManualPlayerController controller, Random r, List<Ship> remainShip, Board board) {
    super(r, remainShip, board);
    this.controller = controller;
  }


  /**
   * @return the name of this player
   */
  @Override
  public String name() {
    return "Player1";
  }


  /**
   * return the shots user input, and make the shots list empty
   *
   * @return the shot user input
   */
  @Override
  public List<Coord> takeShots() {
    List<Coord> userShorts;
    userShorts = this.controller.handlePlayerTakeShort(this.remainShip.size(), true);
    while (!this.validInput(userShorts)) {
        userShorts = this.controller.handlePlayerTakeShort(this.remainShip.size(), false);
    }
    for (Coord c : userShorts) {
      Coord onboard = c.findCoord(this.board.getOpponentBoard());
      onboard.handleHit();
    }
    return userShorts;
  }

  /**
   * check if the Coords is valid
   *
   * @param list is the user input coordinates
   * @return if the input in valid
   */
  private boolean validInput(List<Coord> list) {
    for (Coord c : list) {
      try {
        c.findCoord(board.getBoard());
      } catch (Exception e) {
        return false;
      }
    }
    return true;
  }


  /**
   * mark all the coordinate that is successful Hits as Hit on the opponentBoard
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    for (Coord c : shotsThatHitOpponentShips) {
      c.findAndHit(board.getOpponentBoard());
    }
  }


  /**
   * return the information to view
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  @Override
  public void endGame(GameResult result, String reason) {
    switch (result) {
      case WIN -> this.controller.presentPrompt("You win\n" + reason);
      case LOSE -> this.controller.presentPrompt("You lose\n" + reason);
      case DRAW -> this.controller.presentPrompt("Game tile\n" + reason);
      default -> { }
    }
  }

}
