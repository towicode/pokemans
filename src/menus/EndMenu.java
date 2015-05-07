package menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import controller.Engine;
import model.Keyboard;
import model.Map;
import model.SpriteLoader;
import model.Trainer;
import abstracts.GameMenu;
import abstracts.Item;
import abstracts.Pokeman;

/**
 * EndMenu
 * End menu of the game should display the stats of the game: remaining balls,
 * steps taken, and pokemon captured.
 *
 */
public class EndMenu extends GameMenu {

  private static final int LEFT_X = 15;

  
/**
 * draw
 * Draws the endgame screen
 * @param graphics The 2D graphics package that draws the game
 */
  public void draw(Graphics2D graphics) {
    Trainer x = Engine.getTrainer();
    Item pokeballs = x.getItems().get(0);
    graphics.drawImage(SpriteLoader.getLogo(), 3, 5, null);
    graphics.drawString("Balls Left: " + pokeballs.getQuantity(), LEFT_X, 80);
    graphics.drawString("Steps Taken: " + x.getStep_counter(), LEFT_X, 95);
    graphics.drawString("Pokemon Captured: " + x.getPokeman().size(), LEFT_X,
        110);
    graphics.drawString("Items Found: " + (x.getItems().size() - 1), LEFT_X,
        125);

    graphics.drawString("Press 'R' to play again", LEFT_X, 165);

  }

/**
 * update
 * Restarts the game when the R key is pressed 
 * @param keyboard  The keyboard object detecting the player's input
 */
  @Override
  public void update(Keyboard keyboard) {
    // First we'll hand the actual achievement logic.

    Trainer trainer = Engine.getTrainer();
    ArrayList<Pokeman> pokemon = trainer.getPokeman();
    ArrayList<Item> items = trainer.getItems();

    // if we have all 3 items
    if (items.size() >= 3) {
      AchievementsMenu.setItemsAchievement();
    }

    // if we have greater than 21 pokemon
    if (pokemon.size() >= 21) {
      AchievementsMenu.setTwentyOnePlusAchievement();
    }

    boolean pika = false;
    boolean arbk = false;
    boolean eeve = false;
    boolean fearow = false;
    boolean kada = false;
    boolean bulb = false;
    boolean nido = false;
    boolean sand = false;
    boolean butt = false;

    // check to see what pokemon we have, and if we have mew
    // also check if any them are greater than level 60.
    for (Pokeman x : pokemon) {

      if (x.getName().toUpperCase().contains("Mew".toUpperCase())) {
        AchievementsMenu.SetMewAchievement();
      }

      if (x.getName().toUpperCase().contains("pikachu".toUpperCase())) {
        pika = true;
      }

      if (x.getName().toUpperCase().contains("bulbasaur".toUpperCase())) {
        bulb = true;
      }

      if (x.getName().toUpperCase().contains("butterfree".toUpperCase())) {
        butt = true;
      }

      if (x.getName().toUpperCase().contains("eevee".toUpperCase())) {
        eeve = true;
      }

      if (x.getName().toUpperCase().contains("fearow".toUpperCase())) {
        fearow = true;
      }

      if (x.getName().toUpperCase().contains("kadabra".toUpperCase())) {
        kada = true;
      }

      if (x.getName().toUpperCase().contains("nidorino".toUpperCase())) {
        nido = true;
      }

      if (x.getName().toUpperCase().contains("sandslash".toUpperCase())) {
        sand = true;
      }

      if (x.getName().toUpperCase().contains("arbok".toUpperCase())) {
        arbk = true;
      }

      if (x.getLevel() >= 60) {
        AchievementsMenu.setSixtyPlusAchievement();
      }

    }

    // finally check to see if we've caught all 9 pokemon
    if (bulb && butt && eeve && fearow && kada && nido && sand && arbk && pika) {
      AchievementsMenu.setAllPokemonAchievement();
    }

    // now we'll do keyboard logic.

    if (keyboard.isKeyPressed(KeyEvent.VK_R)) {

      Engine.getTrainer().reset();
      Engine.getMap().loadStartingMap(2, 0, 0, 0);
      Engine.setMenu(new Menu());
      Engine.setGameOver(false);

    }

  }

}
