package menus;

import java.awt.Graphics2D;

import abstracts.GameMenu;
import abstracts.Item;
import controller.Engine;
import model.Keyboard;
import model.Trainer;

public class StatusMenu extends GameMenu {

  private static final int LOWEST_Y = 105;
  private static final int LOWER_Y = 75;
  private static final int RIGHT_Y = 45;
  private static final int LEFT_X = 15;

  /**
   * draw Displays the Trainer's stats on the screen
   * 
   * @param graphics
   *          The 2D graphics package that draws the game
   */
  public void draw(Graphics2D graphics) {
    Trainer x = Engine.getTrainer();

    Item pokeballs = x.getItems().get(0);
    graphics.drawString("Balls Left: " + pokeballs.getQuantity(), LEFT_X,
        LEFT_X);
    graphics.drawString("Steps Taken: " + x.getStep_counter(), LEFT_X, RIGHT_Y);
    graphics.drawString("Direction Facing: " + x.getDirection(), LEFT_X,
        LOWER_Y);
    graphics.drawString("Items Found: " + (x.getItems().size() - 1), LEFT_X,
        LOWEST_Y);

  }

  /**
   * update Unused by StatusMenu, nothing to update
   * 
   * @param keyboard
   *          The keyboard object detecting the player's input
   */
  public void update(Keyboard keyboard) {

  }

}
