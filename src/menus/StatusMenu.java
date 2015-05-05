package menus;

import java.awt.Graphics2D;

import abstracts.GameMenu;
import controller.Engine;
import model.Keyboard;
import model.Trainer;

public class StatusMenu extends GameMenu {

  
  public void draw(Graphics2D graphics) {
    Trainer x = Engine.getTrainer();
    graphics.drawString("Balls Left: " + x.getBallCount(), 15, 15);
    graphics.drawString("Steps Taken: " + x.getBallCount(), 15, 45);
    graphics.drawString("Direction Facing: " + x.getDirection(), 15, 90);


  }

  
  public void update(Keyboard keyboard) {
    // TODO Auto-generated method stub

  }

}
