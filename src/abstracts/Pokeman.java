package abstracts;

import java.awt.image.BufferedImage;
import java.util.Random;

import model.SpriteLoader;
import controller.Engine;
/**
 * Defines a pokeman. The pokeman has a name, level, catch rate, and run rate. 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public abstract class Pokeman {
  
  public final SpriteLoader loader = new SpriteLoader();;
  //private final Double A4 = 0.000001826265179475945;
  //private final Double A3 = -0.0003948867186873706;
  //private final Double A2 = 0.030013899160742596;
  //private final Double A1 = -1.3674011425582648;
  //private final double A0 = 51.00964742917333;

  
  private String name;
  private int level;
  public int toRun;
  public int toCatch;

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

  public boolean tryToCatch(int angry, int eating) {
    Random r = new Random();
    int Low = 0;
    int High = 100;
    int rand = r.nextInt(High - Low) + Low;
    this.toCatch = 50+eating*5-angry*3;
    

    if (rand < toCatch) {
      //Engine.getTrainer().addPokemon(this); gets taken care of in battle
      return true;
    }

    return false;
  }

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
  public BufferedImage getSprite() {
	  return loader.GetPokeman(this.getName());
  }

  public boolean tryToRun(int battleLength, int angry, int eating) {
	  this.toRun = 50-eating*10+angry*4+battleLength;
    return checkRun() || battleLength > 10;
  }
}
