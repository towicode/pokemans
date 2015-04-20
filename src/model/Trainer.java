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

  public void update(Keyboard keyboard) {
    if (appearanceUpdateFlag) {
      appearanceUpdateFlag = false;
      updateAppearance();
    }
    handleMovementRequest(keyboard);
    animate();
  }

  public void draw(Graphics graphics) {
    if (mySprite == null) {
      updateAppearance(); // let's try to fix it first.. just incase..
    }
    if (mySprite != null) {

      graphics.drawImage(mySprite, tileX, tileY, null);
      /*
       * graphics.setColor(Color.RED); graphics.drawRect(tileX, tileY, 16, 16);
       */
    }
  }

  public void handleMovementRequest(Keyboard keyboard) {
    if (tileX != destX || tileY != destY) {
      return; // we're already moving, wait.
    }
    boolean positionUpdateFlag = false;
    int nextX = tileX;
    int nextY = tileY;
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
      switch (keyCode) {
      case KeyEvent.VK_UP:
        direction = Direction.NORTH;
        nextY -= 16;
        break;
      case KeyEvent.VK_DOWN:
        direction = Direction.SOUTH;
        nextY += 16;
        break;
      case KeyEvent.VK_LEFT:
        direction = Direction.EAST;
        nextX -= 16;
        break;
      case KeyEvent.VK_RIGHT:
        direction = Direction.WEST;
        nextX += 16;
        break;
      }
      if (engine.isInBounds(16, nextX, nextY)) {
        if (lastStepTaken <= System.currentTimeMillis() - 600) {
          lastStepTaken = System.currentTimeMillis();
          destX = nextX;
          destY = nextY;
        }
      }
    }
  }

  private void animate() {
    if (tileX != destX || tileY != destY) {
      if (lastAnimationSequence <= System.currentTimeMillis() - 150) {
        lastAnimationSequence = System.currentTimeMillis();
        animationFrame++;
        if (animationFrame > 3) {
          animationFrame = 0;
          appearanceUpdateFlag = true;
        }
        switch (direction) {
        case NORTH:
          if (engine.isInBounds(4, tileX, tileY - 4)) {
            tileY -= 4;
          }
          break;
        case SOUTH:
          if (engine.isInBounds(4, tileX, tileY + 4)) {
            tileY += 4;
          }
          break;
        case EAST:
          if (engine.isInBounds(4, tileX - 4, tileY)) {
            tileX -= 4;
          }
          break;
        case WEST:
          if (engine.isInBounds(4, tileX + 4, tileY)) {
            tileX += 4;
          }
          break;
        }
        updateAppearance();
      }
    }
    if (destX == tileX && destY == tileY) {
      animationFrame = 0;
    }
  }

  public void teleport(int x, int y) {
    destX = tileX = x;
    destY = tileY = y;
  }

  private void updateAppearance() {
    try {
      int animationSequence = (direction.getId() * 4) + animationFrame;
      // System.out.println("anim sequence: " + animationSequence + " (frame: "
      // + animationFrame + ")");
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