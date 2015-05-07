package menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import abstracts.GameMenu;
import abstracts.Item;
import controller.Engine;
import model.Keyboard;
import model.Trainer;

public class ItemMenu extends GameMenu {

  int index = 0;
  private long lastAnimationSequence;



/**draw
 * Draws the item menu on the screen.
 * @param graphics The 2D graphics package that draws the game
 */
  
  public void draw(Graphics2D graphics) {

    Trainer trainer = Engine.getTrainer();
    ArrayList<Item> x = trainer.getItems();
    Item i = trainer.getItems().get(index);

    graphics.drawString("Name: " + i.getName(), 15, 15);
    graphics.drawString("Quantity: " + i.getQuantity(), 15, 45);
    graphics.drawString("Description: " + i.getDescription(), 15, 75);
    graphics.drawImage(i.getSprite(), 80, 100, null);

    if (index != 0) {
      graphics.fillPolygon(new int[] { 15, 30, 30 },
          new int[] { 145, 130, 160 }, 3);

    }

    if (index != x.size() - 1) {

      graphics.fillPolygon(new int[] { 200, 200, 215 }, new int[] { 160, 130,
          145 }, 3);
    }

    graphics.drawPolygon(new int[] { 15, 30, 30 }, new int[] { 145, 130, 160 },
        3);
    graphics.drawPolygon(new int[] { 200, 200, 215 },
        new int[] { 160, 130, 145 }, 3);

    // draw image
  }

/**
 * update
 * Updates the menu when left or right keys are pressed, to show the new item.
 * @param keyboard  The keyboard object detecting the player's input
 */
  
  public void update(Keyboard keyboard) {

    Trainer trainer = Engine.getTrainer();
    ArrayList<Item> x = trainer.getItems();

    int keyCode = -1;

    if (lastAnimationSequence <= System.currentTimeMillis() - 150) {
      lastAnimationSequence = System.currentTimeMillis();

      if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)
          || keyboard.isKeyPressed(KeyEvent.VK_A)) {
        keyCode = KeyEvent.VK_LEFT;
      }
      if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)
          || keyboard.isKeyPressed(KeyEvent.VK_D)) {
        keyCode = KeyEvent.VK_RIGHT;
      }

      if (keyCode == KeyEvent.VK_LEFT) {
        if (index == 0)
          return;
        index--;
      }

      if (keyCode == KeyEvent.VK_RIGHT) {
        if (index == x.size() - 1)
          return;
        index++;
      }
    }
  }
}
