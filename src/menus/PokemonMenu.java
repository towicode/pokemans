package menus;

import java.awt.Graphics2D;

import controller.Engine;
import model.Item;
import model.Keyboard;
import model.Pokeman;
import model.Trainer;
import interfaces.GameMenu;

public class PokemonMenu extends GameMenu {

  int index = 0;

  public void draw(Graphics2D graphics) {
    Trainer x = Engine.getTrainer();
    Pokeman i = x.getPokeman().get(index);

    graphics.drawString("Name: " + i.getName(), 15, 15);
    graphics.drawString("Quantity: " + i.getLevel(), 15, 45);
    graphics.drawImage(i.getSprite(), 15, 140, null);
  }

  public void update(Keyboard keyboard) {
    // TODO Scroll through pokemon

  }

}
