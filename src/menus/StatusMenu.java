package menus;

import java.awt.Graphics2D;

import abstracts.GameMenu;
import controller.Engine;
import model.Keyboard;
import model.Trainer;

public class StatusMenu extends GameMenu {

  private static final int LOWER_Y = 90;
  private static final int RIGHT_Y = 45;
  private static final int LEFT_X = 15;

  public void draw(Graphics2D graphics) {
    Trainer x = Engine.getTrainer();
    graphics.drawString("Balls Left: " + x.getBallCount(), LEFT_X, LEFT_X);
    graphics.drawString("Steps Taken: " + x.getBallCount(), LEFT_X, RIGHT_Y);
    graphics.drawString("Direction Facing: " + x.getDirection(), LEFT_X,
        LOWER_Y);

  }

  public void update(Keyboard keyboard) {
    // TODO Auto-generated method stub

  }

}
