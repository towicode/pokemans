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

import model.Battle;
import model.Keyboard;
import model.Map;
import model.Menu;
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
  private static Menu menu;

  private static boolean isInBattle;
  private static boolean isInMenu;

  public static void main(String args[]) {
    new Engine();
  }

  public Engine() {

    this.sprites = new SpriteLoader();
    this.trainer = new Trainer(sprites);
    this.map = new Map(sprites);
    map.loadStartingMap();

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

    if (battle != null)
      isInBattle = true;
    else
      isInBattle = false;
    if (isInBattle) {
      battle.draw(graphics);
      battle.update(keyboard);

    }
    if (!isInBattle) {

      if (isInMenu) {

        menu.draw(graphics);
        menu.update(keyboard);

      } else {
        map.draw(graphics);
        trainer.draw(graphics);
        trainer.update(keyboard, map);
      }
    }
    // sync the framerate to reduce stutter
    Toolkit.getDefaultToolkit().sync();
  }

  /**
   * handleKeyboardInput(Keyevent e)
   * 
   * @param e
   * 
   * 
   */

  public void handleKeyboardInput(KeyEvent e) {
    // TODO Auto-generated method stub

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
