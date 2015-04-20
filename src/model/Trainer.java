package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import controller.Engine;

public class Trainer {

  private final Engine engine;
  private final SpriteLoader loader;

  // player
  private BufferedImage mySprite;
  private boolean ridingBicycle = false;
  private int tileX = 112;
  private int tileY = 80;
  private Direction direction = Direction.SOUTH;
  private boolean appearanceUpdateFlag = false;
  private long lastStepTaken = 0L;
  private int animationFrame = -1;
  private long lastAnimationSequence = 0L;
  private int destX = tileX;
  private int destY = tileY;

  public Trainer(Engine engine, SpriteLoader loader) {
    this.engine = engine;
    this.loader = loader;
  }

  public void update(Keyboard keyboard, Map map) {

    if (appearanceUpdateFlag) {
      appearanceUpdateFlag = false;
      updateAppearance();
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

  public void teleport(int x, int y) {
    destX = tileX = x;
    destY = tileY = y;
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

  public int getX() {
    return tileX;
  }

  public int getY() {
    return tileY;
  }

  public int getDX() {
    return destX;
  }

  public int getDY() {
    return destY;
  }

}