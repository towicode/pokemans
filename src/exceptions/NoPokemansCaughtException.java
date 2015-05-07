package exceptions;

import java.awt.Graphics2D;

import model.Trainer;
import controller.Engine;

@SuppressWarnings("serial")
public class NoPokemansCaughtException extends Throwable {
  public NoPokemansCaughtException(Graphics2D graphics) {
    graphics.drawString("You don't have any...yet", 15, 15);
  }

}
