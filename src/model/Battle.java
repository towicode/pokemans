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
  
  /**
   * Battle(Pokeman enemy, Trainer player)
   * 
   * Constructor for the battle class. Keeps track of the battle length, enemy, and player.
   * 
   * @param enemy		The pokeman that the player is trying to catch in the battle.
   * @param player		The player's Trainer.
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
   * Throws a rock, resetting the enemy's eat counter, and adding to their angry counter.
   * 
   * 
   */
  public void throwRock() {
	  eating =  0;
	  angry  += ((int) Math.random() * 5);
  }
  /**
   * throwBait()
   * 
   * Throws a piece of bait, resetting the enemy's angry counter, and adding to their eat counter.
   * 
   * 
   */
  public void throwBait() {
	  angry =   0;
	  eating += ((int) Math.random() * 5);
  }
  /**
   * runaway()
   * 
   * The pokeman runs away, ending the battle. This occurs based on the pokeman's settings, and the angry counter of the
   * current battle.
   * 
   * 
   */
  public void runAway() {
	  
  }
  /**
   * throwBall()
   * 
   * Throws a pokeball, attempting to catch the pokeman. This uses 1 ball from the trainer's stock.
   * 
   * 
   */
  public void throwBall() {
	  enemy.tryToCatch();
	  player.ballCount--;
	 
  }
}
