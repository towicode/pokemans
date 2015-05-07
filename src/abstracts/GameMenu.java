package abstracts;

import java.awt.Graphics2D;

import model.Keyboard;
/**
 * GameMenu
 * Constructor for the GameMenu abstract class
 * 
 *
 */
public abstract class GameMenu {
/** draw
 * Draws the graphics on the screen
 * 
 * @param graphics
 */
  public abstract void draw(Graphics2D graphics);
    // TODO Auto-generated method stub
/**
 * update
 * Sends an update with the keyboard input
 * @param keyboard
 */
  public abstract void update(Keyboard keyboard);
  // TODO Auto-generated method stub

}
