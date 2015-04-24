package model;

public class Battle {

  public Pokeman enemy;
  public int battleLength;
  public Trainer player;
  

  public Battle(Pokeman enemy, Trainer player) {
    this.enemy = enemy;
    battleLength = 0;
    this.player = player;
  }

  public void throwRock() {
	  
  }

  public void throwBait() {
	  
  }

  public void runAway() {
	  
  }

  public void throwBall() {
	  enemy.tryToCatch();
	  player.ballCount--;
	 
  }
}
