package menus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import controller.Engine;
import abstracts.GameMenu;
import abstracts.Item;
import abstracts.Pokeman;
import model.Constants;
import model.Keyboard;
import model.Trainer;
/**
 * AchievementsMenu
 * Stores the achievements for the game, and draws them in the menu
 * 
 *
 */
public class AchievmentsMenu extends GameMenu {

  private static final int TEXT_HEIGHT = 22;

  private static final int TEXT_OFFSET = 15;

  private static final int BOX_HEIGHT = 36;

  private static Preferences prefs = Preferences.userRoot().node(
      "PokeMansStorage");

  private static final String MEW_ACHIEVEMENT = "xcx1";
  private static final String ALL_POKEMON_ACHIEVEMENT = "xcx2";
  private static final String ITEMS_ACHIEVEMENT = "xcx3";
  private static final String SIXTY_PLUS_ACHIEVEMENT = "xcx4";
  private static final String TWENTY_ONE_ACHIEVEMENT = "xcx5";
/**
 * draw
 * Draws the achievements on the screen
 * @param graphics The 2D graphics package that draws the game
 */
  public void draw(Graphics2D graphics) {
    // TODO Auto-generated method stub

    // 5 rectangles
    // draw a gold star if completed

    // 1 caught mew
    // 2 caught all 10 pokemon
    // 3 found both items
    // 4 caught a level 60+ pokemon
    // 5 caught 21 + pokemon on a single run.

    // use java preferences to store the achievements
    // http://www.vogella.com/tutorials/JavaPreferences/article.html

    graphics.drawRect(0, 0, Constants.FRAME_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, BOX_HEIGHT, Constants.FRAME_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, BOX_HEIGHT * 2, Constants.FRAME_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, BOX_HEIGHT * 3, Constants.FRAME_WIDTH, BOX_HEIGHT);
    graphics.drawRect(0, BOX_HEIGHT * 4, Constants.FRAME_WIDTH, BOX_HEIGHT);

    graphics.drawString("Caught Mew", TEXT_OFFSET, TEXT_HEIGHT);
    graphics.drawString("Caught all other 9 Pokemon", TEXT_OFFSET, TEXT_HEIGHT
        + BOX_HEIGHT);
    graphics.drawString("Found all items", TEXT_OFFSET, TEXT_HEIGHT
        + BOX_HEIGHT * 2);
    graphics.drawString("Caught 21+ pokemon at once", TEXT_OFFSET, TEXT_HEIGHT
        + BOX_HEIGHT * 3);
    graphics.drawString("Caught a level 60+ pokemon", TEXT_OFFSET, TEXT_HEIGHT
        + BOX_HEIGHT * 4);

    // gonna draw 5 star outlines
    // TIL; drawing stars is hard
    for (int i = 0; i < 5; i++) {
      graphics.drawPolygon(new int[] { 206, 209, 214, 210, 212, 206, 202, 203,
          200, 205 }, new int[] { 10 + (BOX_HEIGHT * i), 15 + (BOX_HEIGHT * i),
          16 + (BOX_HEIGHT * i), 19 + (BOX_HEIGHT * i), 24 + (BOX_HEIGHT * i),
          21 + (BOX_HEIGHT * i), 24 + (BOX_HEIGHT * i), 19 + (BOX_HEIGHT * i),
          16 + (BOX_HEIGHT * i), 15 + (BOX_HEIGHT * i) }, 10);
    }
    Color reset = graphics.getColor();

    // fill in the star if the achievement has been bested.
    graphics.setColor(Color.YELLOW);
    if (prefs.getBoolean(MEW_ACHIEVEMENT, false)) {
      graphics.fillPolygon(new int[] { 206, 209, 214, 210, 212, 206, 202, 203,
          200, 205 }, new int[] { 10 + (BOX_HEIGHT * 0), 15 + (BOX_HEIGHT * 0),
          16 + (BOX_HEIGHT * 0), 19 + (BOX_HEIGHT * 0), 24 + (BOX_HEIGHT * 0),
          21 + (BOX_HEIGHT * 0), 24 + (BOX_HEIGHT * 0), 19 + (BOX_HEIGHT * 0),
          16 + (BOX_HEIGHT * 0), 15 + (BOX_HEIGHT * 0) }, 10);
    }

    if (prefs.getBoolean(ALL_POKEMON_ACHIEVEMENT, false)) {
      graphics.fillPolygon(new int[] { 206, 209, 214, 210, 212, 206, 202, 203,
          200, 205 }, new int[] { 10 + (BOX_HEIGHT * 1), 15 + (BOX_HEIGHT * 1),
          16 + (BOX_HEIGHT * 1), 19 + (BOX_HEIGHT * 1), 24 + (BOX_HEIGHT * 1),
          21 + (BOX_HEIGHT * 1), 24 + (BOX_HEIGHT * 1), 19 + (BOX_HEIGHT * 1),
          16 + (BOX_HEIGHT * 1), 15 + (BOX_HEIGHT * 1) }, 10);
    }

    if (prefs.getBoolean(ITEMS_ACHIEVEMENT, false)) {
      graphics.fillPolygon(new int[] { 206, 209, 214, 210, 212, 206, 202, 203,
          200, 205 }, new int[] { 10 + (BOX_HEIGHT * 2), 15 + (BOX_HEIGHT * 2),
          16 + (BOX_HEIGHT * 2), 19 + (BOX_HEIGHT * 2), 24 + (BOX_HEIGHT * 2),
          21 + (BOX_HEIGHT * 2), 24 + (BOX_HEIGHT * 2), 19 + (BOX_HEIGHT * 2),
          16 + (BOX_HEIGHT * 2), 15 + (BOX_HEIGHT * 2) }, 10);
    }

    if (prefs.getBoolean(TWENTY_ONE_ACHIEVEMENT, false)) {
      graphics.fillPolygon(new int[] { 206, 209, 214, 210, 212, 206, 202, 203,
          200, 205 }, new int[] { 10 + (BOX_HEIGHT * 3), 15 + (BOX_HEIGHT * 3),
          16 + (BOX_HEIGHT * 3), 19 + (BOX_HEIGHT * 3), 24 + (BOX_HEIGHT * 3),
          21 + (BOX_HEIGHT * 3), 24 + (BOX_HEIGHT * 3), 19 + (BOX_HEIGHT * 3),
          16 + (BOX_HEIGHT * 3), 15 + (BOX_HEIGHT * 3) }, 10);
    }

    if (prefs.getBoolean(SIXTY_PLUS_ACHIEVEMENT, false)) {
      graphics.fillPolygon(new int[] { 206, 209, 214, 210, 212, 206, 202, 203,
          200, 205 }, new int[] { 10 + (BOX_HEIGHT * 4), 15 + (BOX_HEIGHT * 4),
          16 + (BOX_HEIGHT * 4), 19 + (BOX_HEIGHT * 4), 24 + (BOX_HEIGHT * 4),
          21 + (BOX_HEIGHT * 4), 24 + (BOX_HEIGHT * 4), 19 + (BOX_HEIGHT * 4),
          16 + (BOX_HEIGHT * 4), 15 + (BOX_HEIGHT * 4) }, 10);
    }

    graphics.setColor(reset);
    // reset color

  }
/**
 * update
 * Handles keyboard and achievement logic
 * 
 * @param keyboard The keyboard object detecting the player's input
 */
  public void update(Keyboard keyboard) {

    // First we'll hand the actual achievement logic.

    Trainer trainer = Engine.getTrainer();
    ArrayList<Pokeman> pokemon = trainer.getPokeman();
    ArrayList<Item> items = trainer.getItems();

    // if we have all 3 items
    if (items.size() >= 3) {
      setItemsAchievement();
    }

    // if we have greater than 21 pokemon
    if (pokemon.size() >= 21) {
      setTwentyOnePlusAchievement();
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
        SetMewAchievement();
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
        setSixtyPlusAchievement();
      }

    }

    // finally check to see if we've caught all 9 pokemon
    if (bulb && butt && eeve && fearow && kada && nido && sand && arbk && pika) {
      setAllPokemonAchievement();
    }

    // now we'll do keyboard logic.
  }
/**
 * SetMewAchievement
 * Sets the Mew achievement if the Trainer has captured Mew.
 */
  public static void SetMewAchievement() {
    prefs.putBoolean(MEW_ACHIEVEMENT, true);
  }
/**
 * setAllPokemonAchievement
 * Sets the all pokemon acheievement if the trainer has captured the 9 non-mew pokemon.
 */
  public static void setAllPokemonAchievement() {
    prefs.putBoolean(ALL_POKEMON_ACHIEVEMENT, true);
  }
/**
 * setItemsAchievement
 * Sets the Items achievement if the trainer finds all items.
 */
  public static void setItemsAchievement() {
    prefs.putBoolean(ITEMS_ACHIEVEMENT, true);
  }
/**
 * setSixtyPlusAchievement
 * Sets the achievement if the trainer has captured a pokemon of at least level 60.
 */
  public static void setSixtyPlusAchievement() {
    prefs.putBoolean(SIXTY_PLUS_ACHIEVEMENT, true);
  }
/**
 * setTwentyOnePlusAchievement
 * Sets the achievement if the trainer captures 21 pokemon.
 */
  public static void setTwentyOnePlusAchievement() {
    prefs.putBoolean(TWENTY_ONE_ACHIEVEMENT, true);
  }
/**
 * deleteAllStoredData
 * Deletes all stored achievements.
 */
  public static void deleteAllStoredData() {
    prefs.remove(MEW_ACHIEVEMENT);
    prefs.remove(ALL_POKEMON_ACHIEVEMENT);
    prefs.remove(ITEMS_ACHIEVEMENT);
    prefs.remove(SIXTY_PLUS_ACHIEVEMENT);
    prefs.remove(TWENTY_ONE_ACHIEVEMENT);
  }

}
