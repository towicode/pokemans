package menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import abstracts.GameMenu;
import abstracts.Item;
import abstracts.Pokeman;
import controller.Engine;
import model.Keyboard;
import model.Trainer;

public class PokemonMenu extends GameMenu {

  int index = 0;
  private long lastAnimationSequence;
/**
 * draw
 * Draws the pokemon on the screen.
 * @param graphics
 */
  public void draw(Graphics2D graphics) {
    Trainer trainer = Engine.getTrainer();

    if (trainer.getPokeman() == null || trainer.getPokeman().size() == 0) {
      graphics.drawString("You don't have any...yet", 15, 15);

    }

    else {

      ArrayList<Pokeman> x = trainer.getPokeman();

      Pokeman i = x.get(index);

      graphics.drawString("Name: " + i.getName(), 15, 15);
      graphics.drawString("Level: " + i.getLevel(), 15, 45);
      graphics.drawImage(i.getSprite(), 80, 100, null);

      if (index != 0) {
        graphics.fillPolygon(new int[] { 15, 30, 30 }, new int[] { 145, 130,
            160 }, 3);

      }

      if (index != x.size() - 1) {

        graphics.fillPolygon(new int[] { 200, 200, 215 }, new int[] { 160, 130,
            145 }, 3);
      }

      graphics.drawPolygon(new int[] { 15, 30, 30 },
          new int[] { 145, 130, 160 }, 3);
      graphics.drawPolygon(new int[] { 200, 200, 215 }, new int[] { 160, 130,
          145 }, 3);

    }
  }
/**
 * update
 * Updates the pokemon on screen when the left or right key is pressed
 */
  public void update(Keyboard keyboard) {
    Trainer trainer = Engine.getTrainer();
    ArrayList<Pokeman> x = trainer.getPokeman();

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
