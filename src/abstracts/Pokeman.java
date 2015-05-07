package abstracts;

import java.awt.image.BufferedImage;
import java.util.Random;

import model.SpriteLoader;
import controller.Engine;

/**
 * Defines a pokeman. The pokeman has a name, level, catch rate, and run rate.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public abstract class Pokeman {

  public final SpriteLoader loader = new SpriteLoader();;
  // private final Double A4 = 0.000001826265179475945;
  // private final Double A3 = -0.0003948867186873706;
  // private final Double A2 = 0.030013899160742596;
  // private final Double A1 = -1.3674011425582648;
  // private final double A0 = 51.00964742917333;

  private String name;
  private int level;
  public int toRun;
  public int toCatch;

  /**
   * Pokeman Constructor for the Pokeman abstract class
   * 
   * @param name
   *          The name of the pokeman
   * @param level
   *          The level of the pokeman
   */
  public Pokeman(String name, int level) {
    this.name = name;
    this.level = level;

    // y = a4*x^4 + a3*x^3 + a2*x^2 + a1*x^1 + a0
    // http://i.imgur.com/loj05N9.png

    // 4 part calculation c1-> c4
    // double c1 = A4 * Math.pow(level, 4);
    // double c2 = A3 * Math.pow(level, 3);
    // double c3 = A2 * Math.pow(level, 2);
    // double c4 = A1 * level;
    // this.toCatch = (int) (c1 + c2 + c3 + c4 + A0);

    // this.toRun = 100 - toCatch * 2;

  }

  /**
   * tryToCatch Checks a randomly generated number against an equation using the
   * angry and eating stats. If the random number is lower than the calculated
   * number, the pokeman is caught.
   * 
   * @param angry
   *          The angry stat of the pokeman, modified by throwing rocks.
   * @param eating
   *          The eating stat of the pokemon, modified by throwing bait.
   * @return
   */
  public boolean tryToCatch(int angry, int eating) {
    Random r = new Random();
    int Low = 0;
    int High = 100;
    int rand = r.nextInt(High - Low) + Low;
    this.toCatch = 50 + eating * 5 - angry * 3;

    // bracelet increases catch chance by 10%, or something like that.
    if (Engine.getTrainer().hasBracelet()) {
      System.out.println("we're using the braclet");
      this.toCatch = 60 + eating * 5 - angry * 3;
    }

    if (rand < toCatch) {
      return true;
    }

    return false;
  }

  /**
   * Generates a random number and checks if the pokemon can run by comparing it
   * to the toRun stat.
   * 
   * @return boolean True if the pokemon can run, false otherwise.
   */
  public boolean checkRun() {

    Random r = new Random();
    int Low = 0;
    int High = 100;
    int rand = r.nextInt(High - Low) + Low;

    if (rand < toRun) {
      return true;
    }

    return false;

  }

  /**
   * getName Gets the name of the Pokeman
   * 
   * @return String The name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the Pokeman
   * 
   * @param name
   *          The name of the Pokeman
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * getLevel Returns the level of the Pokeman
   * 
   * @return int The level of the Pokeman
   */
  public int getLevel() {
    return level;
  }

  /**
   * setLevel Sets the level of the Pokeman
   * 
   * @param level
   *          The level of the Pokeman
   */
  public void setLevel(int level) {
    this.level = level;
  }

  /**
   * getSprite Returns the sprite for the Pokeman
   * 
   * @return BufferedImage The sprite for the Pokeman
   */

  public BufferedImage getSprite() {
    return loader.GetPokeman(this.getName());
  }

  /**
   * Calculates the run chance of the Pokeman, using the battlelength, eating,
   * and angry stats. If the battle length is greater than 10, or if the toRun
   * stat is greater than the random value generated in checkRun, the Pokemon
   * runs.
   * 
   * @param battleLength
   *          The length of the current battle
   * @param angry
   *          The angry stat of the Pokeman
   * @param eating
   *          The eating stat of the Pokeman
   * @return boolean True if the Pokeman runs ,false if it does not.
   */
  public boolean tryToRun(int battleLength, int angry, int eating) {
    this.toRun = 50 - eating * 10 + angry * 4 + battleLength;
    return checkRun() || battleLength > 10;
  }
}
