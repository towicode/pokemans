package model;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import view.BattlePanel;
import view.GameWindow;
import model.pokemons.Pikachu;
import controller.Engine;

/**
 * Defines a pokeman trainer. The trainer has a sprite, a step counter, a ball
 * counter, a direction he or she is facing, a location, and animations. The
 * trainer can change their tile by moving, and check if they are currently in
 * pokeman grass to see if a pokeman can be encountered.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */

public class Trainer {

  private final SpriteLoader loader;
  private final int mapX = 112;
  private final int mapY = 80;
  private int tileX;
  private int tileY;
  private int destX;
  private int destY;
  private int step_counter = 0;

  // player
  private BufferedImage mySprite;
  private boolean ridingBicycle = false;
  private Direction direction = Direction.SOUTH;
  private boolean appearanceUpdateFlag = false;
  private int animationFrame = -1;
  private long lastAnimationSequence = 0L;
  private int step_ensure = 0;
  public int ballCount = 30;

  /**
   * Trainer()
   * 
   * Constructor for the trainer class.
   * 
   * 
   */

  public Trainer(SpriteLoader loader) {
    this.loader = loader;
    this.tileX = 7;
    this.tileY = 7;
    this.destX = 7;
    this.destY = 7;
  }

  /**
   * update(Keyboard keyboard, Map map)
   * 
   * Updates the player's position on the map based on the keys input. Prints
   * the steps taken and the current location.
   * 
   * @param keyboard
   *          The key input from the user
   * @param map
   *          The map the player is currently in
   * 
   * 
   */
  public void update(Keyboard keyboard, Map map) {

    if (appearanceUpdateFlag) {
      appearanceUpdateFlag = false;
      updateAppearance();
    }
    if (!handleMovementRequest(keyboard, map)) {
      return;
    }

    if (tileX == destX && tileY == destY) {

      return; // We're at our destination.
    }

    step_ensure = animate(map, step_ensure);

    if (step_ensure <= 3) {
      return;

    }

    switch (direction) {
    case NORTH:
      setTileY(getTileY() - 1);
      break;
    case SOUTH:
      setTileY(getTileY() + 1);
      break;
    case EAST:
      setTileX(getTileX() - 1);
      break;
    case WEST:
      setTileX(getTileX() + 1);
      break;
    }
    step_counter++;

    if (isInPokeGrass(this)) {
      int r = (int) (Math.random() * (100 - 0)) + 0;

      if (r < 10) {
        r = (int) (Math.random() * (100 - 0)) + 0; // level
        Pokeman x = new Pikachu("Pikachu", r);
        Battle encounter = new Battle(x, this);

        // Notify engine.
        System.out.println("We encountered a level " + x.getLevel() + " "
            + x.getName());

      }

    }

    System.out.println("Location is " + getTileX() + " " + getTileY()
        + "  Steps Taken: " + step_counter);
    step_ensure = 0;

  }

  /**
   * isInPokeGrass()
   * 
   * Checks if the tile the player is in is a grass tile. Currently always
   * returns true, so pokemans can be found anywhere on the map.
   * 
   * @param trainer
   *          The player
   * 
   * @return boolean True always for now. In the future, will return true if the
   *         player is in grass, false otherwise.
   */
  private boolean isInPokeGrass(Trainer trainer) {

    // first convert players location to an int
    int location = trainer.getTileY() * 50 + trainer.getTileX();

    // then return if we're in grass.
    if (Engine.getMap().getGrassTileRaw()[location] == 19) {
      return true;
    }

    return false;

  }

  /**
   * draw(Graphics graphics)
   * 
   * Draws the trainer onto the graphics screen.
   * 
   * @param graphics
   *          The screen for the game.
   * 
   */
  public void draw(Graphics graphics) {
    if (mySprite == null) {
      updateAppearance(); // let's try to fix it first.. just incase..
    }
    if (mySprite != null) {

      graphics.drawImage(mySprite, mapX, mapY, null);
    }
  }

  /**
   * handleMovementRequest(Keyboard keyboard, Map map)
   * 
   * Tells the engine that the player has attempted to move, and handles if the
   * square they are attempting to move into is a solid object or ground they
   * can walk on.
   * 
   * @param keyboard
   *          The inputs from the user into the keyboard.
   * @param map
   *          The map the trainer is currently in.
   * 
   * @return boolean True if the player is already moving, false if not and the
   *         engine needs to make the trainer move.
   */
  public boolean handleMovementRequest(Keyboard keyboard, Map map) {

    if (getTileX() != destX || getTileY() != destY) {

      return true; // we're already moving
    }

    boolean positionUpdateFlag = false;

    int keyCode = -1;
    if (keyboard.isKeyPressed(KeyEvent.VK_UP)
        || keyboard.isKeyPressed(KeyEvent.VK_W)) {
      keyCode = KeyEvent.VK_UP;
      positionUpdateFlag = true;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)
        || keyboard.isKeyPressed(KeyEvent.VK_S)) {
      keyCode = KeyEvent.VK_DOWN;
      positionUpdateFlag = true;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)
        || keyboard.isKeyPressed(KeyEvent.VK_A)) {
      keyCode = KeyEvent.VK_LEFT;
      positionUpdateFlag = true;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)
        || keyboard.isKeyPressed(KeyEvent.VK_D)) {
      keyCode = KeyEvent.VK_RIGHT;
      positionUpdateFlag = true;
    }
    if (positionUpdateFlag) {
      appearanceUpdateFlag = true;
      switch (keyCode) {
      case KeyEvent.VK_UP:
        direction = Direction.NORTH;
        Tile xN = map.getTiles()[getTileX()][getTileY() - 1];
        for (int bad_text : Constants.NOT_WALKABLE_TEXTURES) {
          if (xN.texture == bad_text)
            return false;
        }
        destX = tileX;
        destY = tileY - 1;
        break;
      case KeyEvent.VK_DOWN:
        direction = Direction.SOUTH;
        Tile xS = map.getTiles()[getTileX()][getTileY() + 1];
        for (int bad_text : Constants.NOT_WALKABLE_TEXTURES) {
          if (xS.texture == bad_text)
            return false;
        }
        destX = tileX;
        destY = tileY + 1;
        break;
      case KeyEvent.VK_LEFT:
        direction = Direction.EAST;
        Tile xE = map.getTiles()[getTileX() - 1][getTileY()];
        for (int bad_text : Constants.NOT_WALKABLE_TEXTURES) {
          if (xE.texture == bad_text)
            return false;
        }
        destX = tileX - 1;
        destY = tileY;
        break;
      case KeyEvent.VK_RIGHT:
        direction = Direction.WEST;
        Tile xW = map.getTiles()[getTileX() + 1][getTileY()];
        for (int bad_text : Constants.NOT_WALKABLE_TEXTURES) {
          if (xW.texture == bad_text)
            return false;
        }
        destX = tileX + 1;
        destY = tileY;
        break;
      }
      return true;
    }
    return false;
  }

  /**
   * animate(Map map, int step_ensure)
   * 
   * Animates the trainer and map when moving.
   * 
   * @param map
   *          The map the player is currently in.
   * @param step_ensure
   *          The step count, this will be returned, incrememnted by 1, by the
   *          method.
   * 
   * @return int The step counter incremented by 1.
   */
  private int animate(Map map, int step_ensure) {
    if (tileX == destX && tileY == destY)
      return step_ensure; // We're at our destination.

    if (lastAnimationSequence <= System.currentTimeMillis() - 150) {
      lastAnimationSequence = System.currentTimeMillis();
      animationFrame++;
      if (animationFrame > 2) {
        animationFrame = 0;
        appearanceUpdateFlag = true;
      }
      switch (direction) {
      case NORTH:
        map.adjustDown();
        break;
      case SOUTH:
        map.adjustUp();
        break;
      case EAST:
        map.adjustRight();
        break;
      case WEST:
        map.adjustLeft();
        break;
      }
      updateAppearance();
      step_ensure++;
    }
    return step_ensure;
  }

  /**
   * updateAppearance()
   * 
   * Updates the players sprie when moving or getting on a bicycle. (Bicycle has
   * not been added)
   * 
   * 
   */
  private void updateAppearance() {
    try {
      int animationSequence = (direction.getId() * 3) + animationFrame;
      mySprite = loader.getPlayer(animationSequence, ridingBicycle);
    } catch (Exception e) {
      System.err.println("Requested sprite is null!");
    }
  }

  /**
   * toggleBicycle()
   * 
   * Toggles the trainer getting on or off a bicycle. (Bicycle has not been
   * added)
   * 
   * 
   */
  public void toggleBicycle() {
    ridingBicycle = !ridingBicycle;
    appearanceUpdateFlag = true;
  }

  /**
   * getTileX()
   * 
   * Getter for the trainer's current tile X value.
   * 
   * @return tileX The trainer's current X tile.
   */
  public int getTileX() {
    return tileX;
  }

  /**
   * setTileX(int tileX)
   * 
   * Setter for the trainer's current tile X value.
   * 
   * @param tileX
   *          The trainer's new X tile.
   */

  public void setTileX(int tileX) {
    this.tileX = tileX;
  }

  /**
   * getTileY()
   * 
   * Getter for the trainer's current tile Y value.
   * 
   * @return tileY The trainer's current Y tile.
   */
  public int getTileY() {
    return tileY;
  }

  /**
   * setTileY(int tileY)
   * 
   * Setter for the trainer's current tile Y value.
   * 
   * @param tileY
   *          The trainer's new Y tile.
   */

  public void setTileY(int tileY) {
    this.tileY = tileY;
  }

}