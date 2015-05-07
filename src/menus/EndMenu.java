package menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import controller.Engine;
import model.Keyboard;
import model.Map;
import model.SpriteLoader;
import model.Trainer;
import abstracts.GameMenu;
import abstracts.Item;

/**
 * 
 * End menu of the game should display the stats of the game: remaining balls,
 * steps taken, and pokemon captured.
 *
 */
public class EndMenu extends GameMenu {

  private static final int LEFT_X = 15;
/**
 * draw
 * Draws the endgame screen
 * @param graphics
 */
  public void draw(Graphics2D graphics) {
    Trainer x = Engine.getTrainer();
    Item pokeballs = x.getItems().get(0);
    graphics.drawImage(SpriteLoader.getLogo(), 3, 5, null);
    graphics.drawString("Balls Left: " + pokeballs.getQuantity(), LEFT_X, 80);
    graphics.drawString("Steps Taken: " + x.getStep_counter(), LEFT_X, 95);
    graphics.drawString("Pokemon Captured: " + x.getPokeman().size(), LEFT_X,
        110);

    graphics.drawString("Press 'R' to play again", LEFT_X, 165);

  }
/**
 * update
 * Restarts the game when the R key is pressed 
 * @param keyboard
 */
  @Override
  public void update(Keyboard keyboard) {
    if (keyboard.isKeyPressed(KeyEvent.VK_R)) {

      Engine.getTrainer().reset();
      Engine.getMap().loadStartingMap(2, 0, 0, 0);
      Engine.setMenu(new Menu());
      Engine.setGameOver(false);

    }

  }

}
