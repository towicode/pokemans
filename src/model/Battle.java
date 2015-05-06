package model;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import abstracts.Item;
import abstracts.Pokeman;
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

  private static final int NONE_SELECTED = 5;
  private static final int RUN = 3;
  private static final int THROW_BALL = 2;
  private static final int THROW_ROCK = 1;
  private static final int THROW_BAIT = 0;
  private static final int POKEBALL_INDEX = 0;
  public Pokeman enemy;
  public int battleLength;
  public Trainer player;
  public int angry = 0;
  public int eating = 0;
  public int currentlySelected = THROW_BAIT; // 0 or 1 or 2 or 3
  private String statusText = "";
  private int animation = 0;
  public static boolean allowInput = true;
  public int animationColor = THROW_BAIT; // 0 = bait, 1 = rock, 2 = pokeball

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
   * @param keyboard
   * 
   * 
   */
  public void throwRock(Keyboard keyboard) {
    animationColor = 1;
    eating = 0;
    angry += ((int) Math.random() * NONE_SELECTED);
    statusText = "You throw a rock at the pokemon.";
    battleLength++;

    Thread t = new Thread() {
      public void run() {

        for (int i = 0; i < 6; i++) {
          try {
            animation++;
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        animation = 0;

        if (enemy.tryToRun(battleLength, angry, eating)) {
          currentlySelected = NONE_SELECTED;
          Battle.allowInput = false;

          while (!keyboard.isKeyPressed(KeyEvent.VK_C)) {
            try {
              statusText = "The Pokeman Ran Away";
              Thread.sleep(200);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          Engine.setBattle(null);
          Battle.allowInput = true;
        } else {
          statusText = "The pokeman looks angry...";
          Battle.allowInput = true;
        }
      }
    };
    t.start();
  }

  /**
   * throwBait()
   * 
   * Throws a piece of bait, resetting the enemy's angry counter, and adding to
   * their eat counter.
   * 
   * @param keyboard
   * 
   * 
   */
  public void throwBait(Keyboard keyboard) {
    animationColor = 0;
    angry = 0;
    eating += ((int) Math.random() * NONE_SELECTED);
    statusText = "You throw some food at the pokemon.";
    battleLength++;
    Thread t = new Thread() {
      public void run() {

        for (int i = 0; i < 6; i++) {
          try {
            animation++;
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        animation = 0;

        if (enemy.tryToRun(battleLength, angry, eating)) {
          currentlySelected = NONE_SELECTED;
          Battle.allowInput = false;

          while (!keyboard.isKeyPressed(KeyEvent.VK_C)) {
            try {
              statusText = "The Pokeman Ran Away";
              Thread.sleep(200);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          Engine.setBattle(null);
          Battle.allowInput = true;
        } else {
          statusText = "The pokeman chows down on the food...";
          Battle.allowInput = true;
        }
      }
    };
    t.start();
  }

  /**
   * runaway()
   * 
   * The pokeman runs away, ending the battle. This occurs based on the
   * pokeman's settings, and the angry counter of the current battle.
   * 
   * @param keyboard
   * 
   * 
   */
  public void runAway(Keyboard keyboard) {
    statusText = "You ran away!...";
    currentlySelected = NONE_SELECTED; // to deselect
    Thread t = new Thread() {
      public void run() {
        Battle.allowInput = false;
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
        while (!keyboard.isKeyPressed(KeyEvent.VK_C)) {
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        Engine.setBattle(null);
        Battle.allowInput = true;
      }
    };
    t.start();

  }

  /**
   * throwBall()
   * 
   * Throws a pokeball, attempting to catch the pokeman. This uses 1 ball from
   * the trainer's stock.
   * 
   * @param keyboard
   * 
   * 
   */
  public void throwBall(Keyboard keyboard) {
    animationColor = 2;
    // get amount of balls
    int poke_amt = player.getItems().get(POKEBALL_INDEX).getQuantity();

    Thread t = new Thread() {
      public void run() {
        Battle.allowInput = false;

        for (int i = 0; i < 6; i++) {
          try {
            animation++;
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        animation = 0;

        if (poke_amt == 0) {

          statusText = "You're out of pokeballs!";
          currentlySelected = NONE_SELECTED;

          while (!keyboard.isKeyPressed(KeyEvent.VK_C)) {
            try {
              Thread.sleep(50);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          Engine.setBattle(null);
          Battle.allowInput = true;
          return;

        }
        // set minus 1
        player.getItems().get(0).setQuantity(poke_amt - 1);

        statusText = "You Throw a ball at the pokeman.";
        if (enemy.tryToCatch(angry, eating)) {
          currentlySelected = NONE_SELECTED; // to deselect
          while (!keyboard.isKeyPressed(KeyEvent.VK_C)) {
            try {
              statusText = "You captured " + enemy.getName();
              Thread.sleep(50);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          player.addPokemon(enemy);
          Engine.setBattle(null);
          Battle.allowInput = true;
        } else if (enemy.tryToRun(battleLength, angry, eating)) {
          statusText = "The Pokeman Ran Away...";
          currentlySelected = NONE_SELECTED; // to deselect
          while (!keyboard.isKeyPressed(KeyEvent.VK_C)) {
            try {
              Thread.sleep(50);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          Engine.setBattle(null);
          Battle.allowInput = true;
        } else {
          statusText = "Aww man it didn't catch";
          Battle.allowInput = true;
        }
      }
    };

    t.start();

    // statusText = "Aww man. It didn't catch!";

  }

  public void draw(Graphics2D graphics) {
    Trainer trainer = Engine.getTrainer();
    Item pokeballs = trainer.getItems().get(POKEBALL_INDEX);
    graphics.drawImage(SpriteLoader.getGroundSprite(), 100, 45, null);
    graphics.drawImage(enemy.getSprite(), 130, 0, null);
    graphics.setColor(Color.WHITE);
    graphics.drawString(enemy.getName(), 15, 45);
    graphics.drawString("lv. " + enemy.getLevel(), 15, 65);

    // 240 x 180
    graphics.drawRect(0, 120, 240, 20);
    graphics.drawString(statusText, 15, 135);
    graphics.drawRect(0, 140, 120, 20);
    graphics.drawString("Throw Bait", 15, 155);
    graphics.drawRect(0, 160, 120, 20);
    graphics.drawString("Throw Rock", 15, 175);
    graphics.drawRect(120, 140, 120, 20);
    graphics.drawString("Balls: " + pokeballs.getQuantity(), 135, 115);
    graphics.drawString("Throw Ball", 135, 155);
    graphics.drawRect(120, 160, 120, 20);
    graphics.drawString("Run", 135, 175);

    graphics.setColor(Color.red);
    switch (currentlySelected) {
    case THROW_BAIT:
      graphics.drawRect(0, 140, 120, 20);
      break;
    case THROW_ROCK:
      graphics.drawRect(0, 160, 120, 20);
      break;
    case THROW_BALL:
      graphics.drawRect(120, 140, 120, 20);
      break;
    case RUN:
      graphics.drawRect(120, 160, 120, 20);
      break;
    default:
      break;
    }

    if (this.animation > 0 && this.animation < 6) {

      // store the composite
      Composite c = graphics.getComposite();
      // store the color
      Color d = graphics.getColor();

      switch (animationColor) {
      case THROW_BAIT:
        graphics.setColor(Color.WHITE);
        break;
      case THROW_ROCK:
        graphics.setColor(Color.red);
        break;
      case THROW_BALL:
        graphics.setColor(Color.yellow);
        break;
      }

      float alpha = animation * 0.1f;
      AlphaComposite alcom = AlphaComposite.getInstance(
          AlphaComposite.SRC_OVER, alpha);
      graphics.setComposite(alcom);

      graphics.fillRect(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);

      // reset the composite
      graphics.setComposite(c);
      // reset the color
      graphics.setColor(d);

    }

    // TODO Auto-generated method stub

  }

  public void update(Keyboard keyboard) throws InterruptedException {

    if (!allowInput)
      return;

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
    if (keyboard.isKeyPressed(KeyEvent.VK_C)) {
      keyCode = KeyEvent.VK_C;
    }

    // determines what selection we currently are at.

    if (currentlySelected == THROW_BAIT && keyCode == 40) {
      currentlySelected = THROW_ROCK;
    } else if (currentlySelected == THROW_BAIT && keyCode == 39) {
      currentlySelected = THROW_BALL;
    }

    else if (currentlySelected == THROW_ROCK && keyCode == 38) {
      currentlySelected = THROW_BAIT;
    }

    else if (currentlySelected == THROW_ROCK && keyCode == 39) {
      currentlySelected = RUN;
    }

    else if (currentlySelected == THROW_BALL && keyCode == 37) {
      currentlySelected = THROW_BAIT;
    }

    else if (currentlySelected == THROW_BALL && keyCode == 40) {
      currentlySelected = RUN;
    }

    else if (currentlySelected == RUN && keyCode == 38) {
      currentlySelected = THROW_BALL;
    }

    else if (currentlySelected == RUN && keyCode == 37) {
      currentlySelected = THROW_ROCK;
    }

    else if (keyCode == KeyEvent.VK_C) {
      switch (currentlySelected) {
      case 0:
        this.throwBait(keyboard);
        Thread.sleep(500);
        break;
      case 1:
        this.throwRock(keyboard);
        Thread.sleep(500);
        break;
      case 2:
        this.throwBall(keyboard);
        Thread.sleep(500);
        break;
      case 3:
        this.runAway(keyboard);
        Thread.sleep(500);

        break;
      }
    }
  }

}
