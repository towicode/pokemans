package model;

/**
 * Defines a pokeman battle. The trainer can throw a ball to attempt to catch the pokeman, throw a piece of bait to 
 * make the pokeman eat, throw a rock to make the pokeman angry, or run from the pokeman. An eating pokeman is less likely to 
 * run or be caught, and an angry pokeman is more likely to run or be caught.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */

public class Battle {

  public Pokeman enemy;
  public int battleLength;
  public Trainer player;
  public int angry = 0;
  public int eating = 0;
  

  public Battle(Pokeman enemy, Trainer player) {
    this.enemy = enemy;
    battleLength = 0;
    this.player = player;
  }

  public void throwRock() {
	  eating =  0;
	  angry  += ((int) Math.random() * 5);
  }

  public void throwBait() {
	  angry =   0;
	  eating += ((int) Math.random() * 5);
  }

  public void runAway() {
	  
  }

  public void throwBall() {
	  enemy.tryToCatch();
	  player.ballCount--;
	 
  }
}
