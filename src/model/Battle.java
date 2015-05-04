package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import controller.Engine;

/**
 * Defines a pokeman battle. The trainer can throw a ball to attempt to catch
 * the pokeman, throw a piece of bait to make the pokeman eat, throw a rock to
 * make the pokeman angry, or run from the pokeman. An eating pokeman is less
 * likely to run or be caught, and an angry pokeman is more likely to run or be
 * caught.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */

public class Battle {

  private long lastAnimationSequence = 0;
  public Pokeman enemy;
  public int battleLength;
  public Trainer player;
  public int angry = 0;
  public int eating = 0;
  public int currentlySelected = 0; // 0 or 1 or 2 or 3
  private String statusText;

  /**
   * Battle(Pokeman enemy, Trainer player)
   * 
   * Constructor for the battle class. Keeps track of the battle length, enemy,
   * and player.
   * 
   * @param enemy
   *          The pokeman that the player is trying to catch in the battle.
   * @param player
   *          The player's Trainer.
   * 
   */
  public Battle(Pokeman enemy, Trainer player) {
    this.enemy = enemy;
    battleLength = 0;
    this.player = player;
  }

  /**
   * throwRock()
   * 
   * Throws a rock, resetting the enemy's eat counter, and adding to their angry
   * counter.
   * 
   * 
   */
  public void throwRock() {
    eating = 0;
    angry += ((int) Math.random() * 5);
    statusText = "You throw a rock at the pokemon.";
    battleLength++;
    if (enemy.tryToRun(battleLength)) {
      statusText = "The Pokeman Ran Away";
      Engine.setBattle(null);
    }
  }

  /**
   * throwBait()
   * 
   * Throws a piece of bait, resetting the enemy's angry counter, and adding to
   * their eat counter.
   * 
   * 
   */
  public void throwBait() {
    angry = 0;
    eating += ((int) Math.random() * 5);
    statusText = "You throw some food at the pokemon.";
    battleLength++;
    if (enemy.tryToRun(battleLength)) {
      statusText = "The Pokeman Ran Away";
      Engine.setBattle(null);
    }

  }

  /**
   * runaway()
   * 
   * The pokeman runs away, ending the battle. This occurs based on the
   * pokeman's settings, and the angry counter of the current battle.
   * 
   * 
   */
  public void runAway() {
    statusText = "You run away!.";
    Engine.setBattle(null);
  }

  /**
   * throwBall()
   * 
   * Throws a pokeball, attempting to catch the pokeman. This uses 1 ball from
   * the trainer's stock.
   * 
   * 
   */
  public void throwBall() {
    player.ballCount--;
    if (enemy.tryToCatch()) {
      statusText = "You captured a pokemon";
      Engine.setBattle(null);
    }
    battleLength++;
    if (enemy.tryToRun(battleLength)) {
      statusText = "The Pokeman Ran Away";
      Engine.setBattle(null);
    }

  }

  public void draw(Graphics2D graphics) {
    graphics.drawImage(enemy.getSprite(), 130, 0, null);
    graphics.setColor(Color.WHITE);
    graphics.drawString(enemy.getName(), 15, 45);
    graphics.drawString("lv. " + enemy.getLevel(), 15, 65);

    // 240 x 180

    graphics.drawRect(0, 140, 120, 20);
    graphics.drawString("Throw Bait", 15, 155);
    graphics.drawRect(0, 160, 120, 20);
    graphics.drawString("Throw Rock", 15, 175);
    graphics.drawRect(120, 140, 120, 20);
    graphics.drawString("Balls: " + 30, 135, 120);
    graphics.drawString("Throw Ball", 135, 155);
    graphics.drawRect(120, 160, 120, 20);
    graphics.drawString("Run", 135, 175);

    graphics.setColor(Color.red);
    switch (currentlySelected) {
    case 0:
      graphics.drawRect(0, 140, 120, 20);
      break;
    case 1:
      graphics.drawRect(0, 160, 120, 20);
      break;
    case 2:
      graphics.drawRect(120, 140, 120, 20);
      break;
    case 3:
      graphics.drawRect(120, 160, 120, 20);
      break;
    }

    // TODO Auto-generated method stub

  }

  public void update(Keyboard keyboard) {

    int keyCode = -1;
    if (keyboard.isKeyPressed(KeyEvent.VK_UP)
        || keyboard.isKeyPressed(KeyEvent.VK_W)) {
      keyCode = KeyEvent.VK_UP;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)
        || keyboard.isKeyPressed(KeyEvent.VK_S)) {
      keyCode = KeyEvent.VK_DOWN;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)
        || keyboard.isKeyPressed(KeyEvent.VK_A)) {
      keyCode = KeyEvent.VK_LEFT;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)
        || keyboard.isKeyPressed(KeyEvent.VK_D)) {
      keyCode = KeyEvent.VK_RIGHT;
    }
    if (keyboard.isKeyPressed(KeyEvent.VK_A)) {
      keyCode = KeyEvent.VK_A;
    }

    System.out.println(keyCode);
    if (lastAnimationSequence <= System.currentTimeMillis() - 25) {
      lastAnimationSequence = System.currentTimeMillis();

      // determines what selection we currently are at.

      if (currentlySelected == 0 && keyCode == 40) {
        currentlySelected = 1;
      } else if (currentlySelected == 0 && keyCode == 39) {
        currentlySelected = 2;
      }

      else if (currentlySelected == 1 && keyCode == 38) {
        currentlySelected = 0;
      }

      else if (currentlySelected == 1 && keyCode == 39) {
        currentlySelected = 3;
      }

      else if (currentlySelected == 2 && keyCode == 37) {
        currentlySelected = 0;
      }

      else if (currentlySelected == 2 && keyCode == 40) {
        currentlySelected = 3;
      }

      else if (currentlySelected == 3 && keyCode == 38) {
        currentlySelected = 2;
      }

      else if (currentlySelected == 3 && keyCode == 37) {
        currentlySelected = 1;
      }

      else if (keyCode == 65) {
        switch (currentlySelected) {
        case 0:
          this.throwBait();
          break;
        case 1:
          this.throwRock();
          break;
        case 2:
          this.throwBall();
          break;
        case 3:
          this.runAway();
          break;
        }
      }
    }
  }

}
