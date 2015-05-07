package menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import controller.Engine;
import model.Keyboard;
import model.SpriteLoader;
import abstracts.GameMenu;

public class StartMenu extends GameMenu {

  private static final int LEFT_X = 15;
/**
 * draw
 * Displays the programmer names and the Controls for the game.
 * @param graphics
 */
  public void draw(Graphics2D graphics) {
    graphics.drawImage(SpriteLoader.getLogo(), 3, 5, null);
    graphics.drawString("By Todd Wickizer", 15, 80);
    graphics.drawString("Andrew Rickus", 15, 95);
    graphics.drawString("Sean Gemberling", 15, 110);

    graphics.drawString("Press 'T' to play ", LEFT_X, 165);
  }
/**
 * update
 * Starts the game when T is pressed
 * @param keyboard
 */
  @Override
  public void update(Keyboard keyboard) {
    if (keyboard.isKeyPressed(KeyEvent.VK_T)) {

      Engine.setGameStarted(true);
      Engine.setMenu(new Menu());

    }

  }

}
