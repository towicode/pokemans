package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abstracts.GameMenu;
import abstracts.Item;
import menus.Menu;
import model.Battle;
import model.Keyboard;
import model.Map;
import model.SpriteLoader;
import model.Trainer;
import view.GameWindow;

/**
 * Defines the game engine.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public class Engine extends Canvas implements Runnable {

  private static final long serialVersionUID = 1L;
  public final GameWindow parentframe;
  private final JPanel frame;
  private final ScheduledExecutorService executor = Executors
      .newScheduledThreadPool(1);
  private Graphics2D graphics;
  private final Runtime runtime = Runtime.getRuntime();
  private final Keyboard keyboard;
  private final SpriteLoader sprites;
  private static Trainer trainer;
  private static Map map;
  private static Battle battle;
  private static GameMenu menu;

  private static boolean isInBattle;
  private static boolean isInMenu;
  public static boolean setEncounterFlag = false;

  public static void main(String args[]) {
    new Engine();
  }

  public Engine() {

    this.sprites = new SpriteLoader();
    Engine.trainer = new Trainer(sprites);
    Engine.map = new Map(sprites);
    Engine.menu = new Menu();
    map.loadStartingMap(2, 0, 0, 0);

    parentframe = new GameWindow();
    frame = parentframe.gamePanel;
    frame.add(this);
    parentframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    parentframe.setResizable(false);
    frame.validate();
    parentframe.pack();
    parentframe.setVisible(true);
    parentframe.toFront();

    this.graphics = (Graphics2D) frame.getGraphics();
    addKeyListener(this.keyboard = new Keyboard(this));
    requestFocus();

    this.executor.scheduleAtFixedRate(this, 0, 35, TimeUnit.MILLISECONDS);

  }

  /**
   * run()
   * 
   * Fills the game screen with map and trainer graphics, and updates them.
   * 
   * 
   */

  @Override
  public void run() {
    graphics.setColor(Color.BLACK);

    graphics.fillRect(0, 0, frame.getWidth(), frame.getHeight());

    if (setEncounterFlag) {

      for (int i = 0; i < 5; i++) {

        if (i % 2 == 0) {
          graphics.setColor(Color.cyan);
          graphics.fillRect(0, 0, 240, 180);
        } else {
          graphics.setColor(Color.blue);
          graphics.fillRect(0, 0, 240, 180);
        }
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      setEncounterFlag = false;

    }

    graphics.setColor(Color.BLACK);

    if (battle != null)
      isInBattle = true;
    else
      isInBattle = false;
    if (isInBattle) {
      battle.draw(graphics);
      try {
        battle.update(keyboard);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
    if (!isInBattle) {

      if (isInMenu) {
        graphics.setColor(Color.white);
        menu.draw(graphics);
        menu.update(keyboard);
        graphics.setColor(Color.BLACK);

      } else {
        map.draw(graphics);
        trainer.draw(graphics);
        trainer.update(keyboard, map);
      }
    }
    // sync the framerate to reduce stutter
    Toolkit.getDefaultToolkit().sync();
  }

  public static GameMenu getMenu() {
    return menu;
  }

  public static void setMenu(GameMenu menu) {
    Engine.menu = menu;
  }

  public static boolean isInMenu() {
    return isInMenu;
  }

  public static void setInMenu(boolean isInMenu) {
    Engine.isInMenu = isInMenu;
  }

  /**
   * handleKeyboardInput(Keyevent e)
   * 
   * @param e
   * 
   * 
   */

  public void handleKeyboardInput(KeyEvent e) {

    // For spawning the menu

    if (!isInBattle())
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        GameMenu menu = new Menu();
        Engine.setMenu(menu);
        Engine.setInMenu(true);
      } else if (e.getKeyCode() == KeyEvent.VK_B) {

        // for riding the bike

        for (Item x : trainer.getItems()) {
          if (x.getName().contains("Bicycle")) {
            trainer.toggleBicycle();
          }
        }
      }
  }

  public static Map getMap() {
    return map;
  }

  public static void setMap(Map map) {
    Engine.map = map;
  }

  public static boolean isInBattle() {
    return isInBattle;
  }

  public static void setInBattle(boolean isInBattle) {
    Engine.isInBattle = isInBattle;
  }

  public static Battle getBattle() {
    return battle;
  }

  public static void setBattle(Battle battle) {
    Engine.battle = battle;
  }

  public static Trainer getTrainer() {
    return trainer;
  }

  public static void setTrainer(Trainer trainer) {
    Engine.trainer = trainer;
  }

}
