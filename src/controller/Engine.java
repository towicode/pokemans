package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Keyboard;
import model.Map;
import model.SpriteLoader;
import model.Trainer;
import view.GameWindow;

public class Engine extends Canvas implements Runnable {

  private static final long serialVersionUID = 1L;
  private final GameWindow parentframe;
  private final JPanel frame;
  private final ScheduledExecutorService executor = Executors
      .newScheduledThreadPool(1);
  private Graphics2D graphics;
  private final Runtime runtime = Runtime.getRuntime();
  private final Keyboard keyboard;
  private final SpriteLoader sprites;
  private final Trainer trainer;
  private final Map map;

  private int frameCount = 0;
  private int previousFrame = 0;

  public static void main(String args[]) {
    new Engine();
  }

  public Engine() {

    this.sprites = new SpriteLoader();
    this.trainer = new Trainer(this, sprites);
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

  @Override
  public void run() {
    map.draw(graphics);

    trainer.draw(graphics);
    graphics.setColor(Color.red);
    graphics.setFont(new Font("Helvetica", Font.BOLD, 12));
    graphics.setColor(Color.BLACK);
    graphics.drawString("TESTING", 13, 21);

  }

  public boolean isInBounds(int i, int nextX, int nextY) {
    // TODO Auto-generated method stub
    return false;
  }

  public void handleKeyboardInput(KeyEvent e) {
    // TODO Auto-generated method stub

    if (e.isAltDown()) {
      map.adjustRight();
    }

  }

}
