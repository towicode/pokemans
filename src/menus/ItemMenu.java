package menus;

import interfaces.GameMenu;

import java.awt.Graphics2D;

import controller.Engine;
import model.Item;
import model.Keyboard;
import model.Trainer;

public class ItemMenu extends GameMenu {

  int index = 0;

  public void draw(Graphics2D graphics) {
    
    System.out.println("we're drawing itemsMenu");

    Trainer trainer = Engine.getTrainer();
    Item i = trainer.getItems().get(index);

    graphics.drawString("Name: " + i.getName(), 15, 15);
    graphics.drawString("Quantity: " + i.getQuantity(), 15, 45);
    graphics.drawString("Description: " + i.getDescription(), 15, 75);

    // draw image
  }

  public void update(Keyboard keyboard) {
    // Toggle keyboard to cycle left and right through items.

  }

}
