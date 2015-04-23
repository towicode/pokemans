package model;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import controller.Engine;

public class Trainer {

  private final Engine engine;
  private final SpriteLoader loader;
  private final int tileX = 112;
  private final int tileY = 80;

  // player
  private BufferedImage mySprite;
  private boolean ridingBicycle = false;
  private Direction direction = Direction.SOUTH;
  private boolean appearanceUpdateFlag = false;
  private int animationFrame = -1;
  private long lastAnimationSequence = 0L;

  public Trainer(Engine engine, SpriteLoader loader) {
    this.engine = engine;
    this.loader = loader;
  }

  public void update(Keyboard keyboard, Map map) {

    if (appearanceUpdateFlag) {
      appearanceUpdateFlag = false;
      updateAppearance();
      //TODO this call needs to include the map variable, It needs to check and see if the direction that the player
      //wants to go is a valid direction
      
      //The best way to do this is probably to keep track of the players "Position" by creating new variables and updating it everytime
      // the animate calls are made below
      
      //the you could cross check that position to an array of (walls) to see if it's allowed or not.
      
    }
    handleMovementRequest(keyboard);

    if (appearanceUpdateFlag) {
      animate(map);
    }
  }

  public void draw(Graphics graphics) {
    if (mySprite == null) {
      updateAppearance(); // let's try to fix it first.. just incase..
    }
    if (mySprite != null) {

      graphics.drawImage(mySprite, tileX, tileY, null);
    }
  }

  public void handleMovementRequest(Keyboard keyboard) {

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
        break;
      case KeyEvent.VK_DOWN:
        direction = Direction.SOUTH;
        break;
      case KeyEvent.VK_LEFT:
        direction = Direction.EAST;
        break;
      case KeyEvent.VK_RIGHT:
        direction = Direction.WEST;
        break;
      }
    }
  }

  private void animate(Map map) {
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
        System.out.println("Moving North");
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
    }
  }


  private void updateAppearance() {
    try {
      int animationSequence = (direction.getId() * 3) + animationFrame;
      mySprite = loader.getPlayer(animationSequence, ridingBicycle);
    } catch (Exception e) {
      System.err.println("Requested sprite is null!");
    }
  }

  public void toggleBicycle() {
    ridingBicycle = !ridingBicycle;
    appearanceUpdateFlag = true;
  }



}