package menus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import abstracts.GameMenu;
import controller.Engine;
import model.Keyboard;

public class Menu extends GameMenu {

  private static final int BOX_HEIGHT = 36;
  private static final int BOX_WIDTH = 240;
  private int currentlySelected = 0;
  private long lastAnimationSequence = 0;
/**
 * draw
 * Draws the game menu on the screen
 * @param graphics The 2D graphics package that draws the game
 */
  public void draw(Graphics2D graphics) {

    // 240 x 180
    graphics.setColor(Color.WHITE);
    graphics.drawRect(0, 0, Menu.BOX_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, BOX_HEIGHT, Menu.BOX_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, 72, Menu.BOX_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, 108, Menu.BOX_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, 144, Menu.BOX_WIDTH, BOX_HEIGHT);

    graphics.drawString("Items", 15, 18);
    graphics.drawString("Caught Pokemon", 15, 54);
    graphics.drawString("Status", 15, 90);
    graphics.drawString("Achievements", 15, 126);
    graphics.drawString("Continue Playing", 15, 162);

    graphics.setColor(Color.RED);
    switch (currentlySelected) {
    case 0:
      graphics.drawRect(0, 0, Menu.BOX_WIDTH, BOX_HEIGHT);
      break;
    case 1:
      graphics.drawRect(0, BOX_HEIGHT, Menu.BOX_WIDTH, BOX_HEIGHT);
      break;
    case 2:
      graphics.drawRect(0, 72, Menu.BOX_WIDTH, BOX_HEIGHT);
      break;
    case 3:
      graphics.drawRect(0, 108, Menu.BOX_WIDTH, BOX_HEIGHT);
      break;
    case 4:
      graphics.drawRect(0, 144, Menu.BOX_WIDTH, BOX_HEIGHT);
      break;

    }
  }
/**
 * update
 * Updates the screen when up and down keys are pressed, or if the selection key is pressed
 */
  public void update(Keyboard keyboard) {
    int keyCode = -1;
    if (keyboard.isKeyPressed(KeyEvent.VK_UP)
        || keyboard.isKeyPressed(KeyEvent.VK_W)) {
      keyCode = KeyEvent.VK_UP;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)
        || keyboard.isKeyPressed(KeyEvent.VK_S)) {
      keyCode = KeyEvent.VK_DOWN;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_C)) {
      keyCode = KeyEvent.VK_C;
    }

    if (lastAnimationSequence <= System.currentTimeMillis() - 150) {
      lastAnimationSequence = System.currentTimeMillis();

      if (keyCode == KeyEvent.VK_UP) {
        if (currentlySelected == 0)
          return;
        currentlySelected--;
      }

      if (keyCode == KeyEvent.VK_DOWN) {
        if (currentlySelected == 4)
          return;
        currentlySelected++;
      }

      if (keyCode == KeyEvent.VK_C) {
        switch (currentlySelected) {
        case 0:
          GameMenu items = new ItemMenu();
          Engine.setMenu(items);
          break;
        case 1:
          GameMenu pokemon = new PokemonMenu();
          Engine.setMenu(pokemon);
          break;
        case 2:
          GameMenu status = new StatusMenu();
          Engine.setMenu(status);
          break;
        case 3:
          GameMenu achievements = new AchievmentsMenu();
          Engine.setMenu(achievements);
          break;
        case 4:
          Engine.setInMenu(false);

        }
      }
    }
  }
}
