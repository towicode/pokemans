package model;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * SpriteLoader
 * Defines a SpriteLoader. This class takes images from the resources file for use by other classes.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public class SpriteLoader {

  private static final int TILE_SIZE = 16;

  private boolean loaded = false;

  // tiles
  private BufferedImage dirt;
  private BufferedImage nothing;

  private BufferedImage dirtNE;
  private BufferedImage dirtNW;
  private BufferedImage dirtSW;
  private BufferedImage dirtSE;
  private BufferedImage dirtN;
  private BufferedImage dirtE;
  private BufferedImage dirtS;
  private BufferedImage dirtW;

  private BufferedImage ramp_E_1;
  private BufferedImage ramp_E_2;
  private BufferedImage ramp_W_1;
  private BufferedImage ramp_W_2;
  private BufferedImage ramp_N_1;
  private BufferedImage ramp_N_2;

  private BufferedImage grass;
  private BufferedImage mountainNE;
  private BufferedImage mountainNW;
  private BufferedImage mountainSW;
  private BufferedImage mountainSE;
  private BufferedImage mountainN;
  private BufferedImage mountainE;
  private BufferedImage mountainS;
  private BufferedImage mountainW;

  private BufferedImage water;
  private BufferedImage waterNE;
  private BufferedImage waterNW;
  private BufferedImage waterSW;
  private BufferedImage waterSE;
  private BufferedImage waterN;
  private BufferedImage waterE;
  private BufferedImage waterS;
  private BufferedImage waterW;

  private BufferedImage fenceNE;
  private BufferedImage fenceNW;
  private BufferedImage fenceSW;
  private BufferedImage fenceSE;
  private BufferedImage fenceN;
  private BufferedImage fenceE;
  private BufferedImage fenceS;
  private BufferedImage fenceW;

  /*
   * // player gfx private BufferedImage player[]; private BufferedImage
   * playerY[]; private BufferedImage playerBicycle[];
   */
  // misc
  private BufferedImage shrub;
  private BufferedImage pokeGrass;
  private BufferedImage stump;
  private BufferedImage rock;
  private BufferedImage pokeball;

  private BufferedImage arbokSprite;
  private BufferedImage pikachuSprite;
  private BufferedImage bulbasaurSprite;
  private BufferedImage butterfreeSprite;
  private BufferedImage eeveeSprite;
  private BufferedImage fearowSprite;
  private BufferedImage kadabraSprite;
  private BufferedImage mewSprite;
  private BufferedImage nidorinoSprite;
  private BufferedImage sandslashSprite;

  private static BufferedImage groundSprite;
  private static BufferedImage pokeball_item;
  private static BufferedImage bike;
  private static BufferedImage bracelet;
  
  private static BufferedImage logo;

  // main-guy sheet

  private BufferedImage trainerN[] = new BufferedImage[3];
  private BufferedImage trainerS[] = new BufferedImage[3];
  private BufferedImage trainerE[] = new BufferedImage[3];
  private BufferedImage trainerW[] = new BufferedImage[3];

  private BufferedImage trainerBN[] = new BufferedImage[3];
  private BufferedImage trainerBS[] = new BufferedImage[3];
  private BufferedImage trainerBE[] = new BufferedImage[3];
  private BufferedImage trainerBW[] = new BufferedImage[3];
/**
 * SpriteLoader
 * Constructor for SpriteLoader. Pulls all of the sprites and sprite sheets from the resource file.
 */
  public SpriteLoader() {
    try {
      BufferedImage sheet = ImageIO.read(new File("./resources/tilesheet.png"));

      logo = ImageIO.read(new File(
          "./resources/Logo.png"));
      arbokSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/arbok80x80.png "));
      pikachuSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/pikachu80x80.png "));
      bulbasaurSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/bulbasaur80x80.png "));
      butterfreeSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/butterfree80x80.png "));
      eeveeSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/eevee80x80.png "));
      fearowSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/fearow80x80.png "));
      kadabraSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/kadabra80x80.png "));
      mewSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/mew80x80.png "));
      nidorinoSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/nidorino80x80.png "));
      sandslashSprite = ImageIO.read(new File(
          "./resources/PokemonSprites/sandslash80x80.png "));
      
      pokeball_item = ImageIO.read(new File(
          "./resources/OtherSprites/pokeball.png"));
      
      bike = ImageIO.read(new File(
          "./resources/OtherSprites/bike.png"));
      
      bracelet = ImageIO.read(new File(
          "./resources/OtherSprites/bracelet.png"));

      setGroundSprite(ImageIO.read(new File(
          "./resources/OtherSprites/groundSprite.png ")));

      this.ramp_E_1 = sheet.getSubimage(0, 0, TILE_SIZE, TILE_SIZE);
      this.ramp_E_2 = sheet.getSubimage(0, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.ramp_W_1 = sheet.getSubimage(TILE_SIZE, 0, TILE_SIZE, TILE_SIZE);
      this.ramp_W_2 = sheet.getSubimage(TILE_SIZE, TILE_SIZE, TILE_SIZE,
          TILE_SIZE);
      this.ramp_N_1 = sheet.getSubimage(0, 32, TILE_SIZE, TILE_SIZE);
      this.ramp_N_2 = sheet.getSubimage(TILE_SIZE, 32, TILE_SIZE, TILE_SIZE);
      this.shrub = sheet.getSubimage(32, 0, TILE_SIZE, TILE_SIZE);
      this.pokeGrass = sheet.getSubimage(32, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.rock = sheet.getSubimage(32, 32, TILE_SIZE, TILE_SIZE);
      this.stump = sheet.getSubimage(48, 32, TILE_SIZE, TILE_SIZE);
      this.pokeball = sheet.getSubimage(48, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.dirt = sheet.getSubimage(80, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.dirtNE = sheet.getSubimage(96, 0, TILE_SIZE, TILE_SIZE);
      this.dirtNW = sheet.getSubimage(64, 0, TILE_SIZE, TILE_SIZE);
      this.dirtSW = sheet.getSubimage(64, 32, TILE_SIZE, TILE_SIZE);
      this.dirtSE = sheet.getSubimage(96, 32, TILE_SIZE, TILE_SIZE);
      this.dirtN = sheet.getSubimage(80, 0, TILE_SIZE, TILE_SIZE);
      this.dirtS = sheet.getSubimage(80, 32, TILE_SIZE, TILE_SIZE);
      this.dirtW = sheet.getSubimage(64, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.dirtE = sheet.getSubimage(96, TILE_SIZE, TILE_SIZE, TILE_SIZE);

      this.grass = sheet.getSubimage(128, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.mountainNE = sheet.getSubimage(144, 0, TILE_SIZE, TILE_SIZE);
      this.mountainNW = sheet.getSubimage(112, 0, TILE_SIZE, TILE_SIZE);
      this.mountainSW = sheet.getSubimage(112, 32, TILE_SIZE, TILE_SIZE);
      this.mountainSE = sheet.getSubimage(144, 32, TILE_SIZE, TILE_SIZE);
      this.mountainN = sheet.getSubimage(128, 0, TILE_SIZE, TILE_SIZE);
      this.mountainS = sheet.getSubimage(128, 32, TILE_SIZE, TILE_SIZE);
      this.mountainW = sheet.getSubimage(112, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.mountainE = sheet.getSubimage(144, TILE_SIZE, TILE_SIZE, TILE_SIZE);

      this.water = sheet.getSubimage(176, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.waterNE = sheet.getSubimage(192, 0, TILE_SIZE, TILE_SIZE);
      this.waterNW = sheet.getSubimage(160, 0, TILE_SIZE, TILE_SIZE);
      this.waterSW = sheet.getSubimage(160, 32, TILE_SIZE, TILE_SIZE);
      this.waterSE = sheet.getSubimage(192, 32, TILE_SIZE, TILE_SIZE);
      this.waterN = sheet.getSubimage(176, 0, TILE_SIZE, TILE_SIZE);
      this.waterS = sheet.getSubimage(176, 32, TILE_SIZE, TILE_SIZE);
      this.waterW = sheet.getSubimage(160, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.waterE = sheet.getSubimage(192, TILE_SIZE, TILE_SIZE, TILE_SIZE);

      this.nothing = sheet.getSubimage(224, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.fenceNE = sheet.getSubimage(240, 0, TILE_SIZE, TILE_SIZE);
      this.fenceNW = sheet.getSubimage(208, 0, TILE_SIZE, TILE_SIZE);
      this.fenceSW = sheet.getSubimage(208, 32, TILE_SIZE, TILE_SIZE);
      this.fenceSE = sheet.getSubimage(240, 32, TILE_SIZE, TILE_SIZE);
      this.fenceN = sheet.getSubimage(224, 0, TILE_SIZE, TILE_SIZE);
      this.fenceS = sheet.getSubimage(224, 32, TILE_SIZE, TILE_SIZE);
      this.fenceW = sheet.getSubimage(208, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      this.fenceE = sheet.getSubimage(240, TILE_SIZE, TILE_SIZE, TILE_SIZE);

      BufferedImage Psheet = ImageIO.read(new File(
          "./resources/trainerSheet.png"));

      trainerN[0] = Psheet.getSubimage(0, 0, TILE_SIZE, TILE_SIZE);
      trainerN[1] = Psheet.getSubimage(TILE_SIZE, 0, TILE_SIZE, TILE_SIZE);
      trainerN[2] = Psheet.getSubimage(32, 0, TILE_SIZE, TILE_SIZE);

      trainerE[0] = Psheet.getSubimage(0, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      trainerE[1] = Psheet.getSubimage(TILE_SIZE, TILE_SIZE, TILE_SIZE,
          TILE_SIZE);
      trainerE[2] = Psheet.getSubimage(32, TILE_SIZE, TILE_SIZE, TILE_SIZE);

      trainerS[0] = Psheet.getSubimage(0, 32, TILE_SIZE, TILE_SIZE);
      trainerS[1] = Psheet.getSubimage(TILE_SIZE, 32, TILE_SIZE, TILE_SIZE);
      trainerS[2] = Psheet.getSubimage(32, 32, TILE_SIZE, TILE_SIZE);

      trainerW[0] = Psheet.getSubimage(0, 48, TILE_SIZE, TILE_SIZE);
      trainerW[1] = Psheet.getSubimage(TILE_SIZE, 48, TILE_SIZE, TILE_SIZE);
      trainerW[2] = Psheet.getSubimage(32, 48, TILE_SIZE, TILE_SIZE);

      BufferedImage PBikesheet = ImageIO.read(new File(
          "./resources/TrainerBicycleSheet.png"));

      trainerBN[0] = PBikesheet.getSubimage(0, 0, TILE_SIZE, TILE_SIZE);
      trainerBN[1] = PBikesheet.getSubimage(TILE_SIZE, 0, TILE_SIZE, TILE_SIZE);
      trainerBN[2] = PBikesheet.getSubimage(32, 0, TILE_SIZE, TILE_SIZE);

      trainerBE[0] = PBikesheet.getSubimage(0, TILE_SIZE, TILE_SIZE, TILE_SIZE);
      trainerBE[1] = PBikesheet.getSubimage(TILE_SIZE, TILE_SIZE, TILE_SIZE,
          TILE_SIZE);
      trainerBE[2] = PBikesheet
          .getSubimage(32, TILE_SIZE, TILE_SIZE, TILE_SIZE);

      trainerBS[0] = PBikesheet.getSubimage(0, 32, TILE_SIZE, TILE_SIZE);
      trainerBS[1] = PBikesheet
          .getSubimage(TILE_SIZE, 32, TILE_SIZE, TILE_SIZE);
      trainerBS[2] = PBikesheet.getSubimage(32, 32, TILE_SIZE, TILE_SIZE);

      trainerBW[0] = PBikesheet.getSubimage(0, 48, TILE_SIZE, TILE_SIZE);
      trainerBW[1] = PBikesheet
          .getSubimage(TILE_SIZE, 48, TILE_SIZE, TILE_SIZE);
      trainerBW[2] = PBikesheet.getSubimage(32, 48, TILE_SIZE, TILE_SIZE);

    } catch (Exception e) {
      System.err
          .println("Pokemans could not load it's sprites " + e.toString());
      System.exit(0);
    }
  }
/**
 * getTile
 * Gets the image for the given tile id.
 * @param type
 * @return BufferedImage
 */
  public BufferedImage getTile(int type) {
    switch (type - 1) { // -1 because I screwed up the alignment.
    case -1:
      return nothing;
    case 0:
      return ramp_E_1;
    case 1:
      return ramp_W_1;
    case 2:
      return shrub;
    case 3:
      return nothing;
    case 4:
      return dirtNW;
    case 5:
      return dirtN;
    case 6:
      return dirtNE;
    case 7:
      return mountainNW;
    case 8:
      return mountainN;
    case 9:
      return mountainNE;
    case 10:
      return waterNW;
    case 11:
      return waterN;
    case 12:
      return waterNE;
    case 13:
      return fenceNW;
    case 14:
      return fenceN;
    case 15:
      return fenceNE;
    case 16:
      return ramp_E_2;
    case 17:
      return ramp_W_2;
    case 18:
      return pokeGrass;
    case 19:
      return pokeball;
    case 20:
      return dirtW;
    case 21:
      return dirt;
    case 22:
      return dirtE;
    case 23:
      return mountainW;
    case 24:
      return grass;
    case 25:
      return mountainE;
    case 26:
      return waterW;
    case 27:
      return water;
    case 28:
      return waterE;
    case 29:
      return fenceW;
    case 30:
      return nothing;
    case 31:
      return fenceE;
    case 32:
      return ramp_N_1;
    case 33:
      return ramp_N_2;
    case 34:
      return rock;
    case 35:
      return stump;
    case 36:
      return dirtSW;
    case 37:
      return dirtS;
    case 38:
      return dirtSE;
    case 39:
      return mountainSW;
    case 40:
      return mountainS;
    case 41:
      return mountainSE;
    case 42:
      return waterSW;
    case 43:
      return waterS;
    case 44:
      return waterSE;

    case 45:
      return fenceSW;
    case 46:
      return fenceS;
    case 47:
      return fenceSE;

    }
    return null;
  }
/**
 * getPlayer
 * Returns the sprite for the player using the current animation sequence value and 
 * bicycle boolean.
 * @param animationSequence
 * @param ridingBicycle 
 * @return BufferedImage
 */
  public BufferedImage getPlayer(int animationSequence, boolean ridingBicycle) {

    if (!ridingBicycle) {
      switch (animationSequence) {
      case 0:
        return trainerS[0];
      case 1:
        return trainerS[1];
      case 2:
        return trainerS[2];
      case 3:
        return trainerW[0];
      case 4:
        return trainerW[1];
      case 5:
        return trainerW[2];
      case 6:
        return trainerN[0];
      case 7:
        return trainerN[1];
      case 8:
        return trainerN[2];
      case 9:
        return trainerE[0];
      case 10:
        return trainerE[1];
      case 11:
        return trainerE[2];
      default:
        return trainerS[1];
      }

    } else {

      switch (animationSequence) {
      case 0:
        return trainerBS[0];
      case 1:
        return trainerBS[1];
      case 2:
        return trainerBS[2];
      case 3:
        return trainerBW[0];
      case 4:
        return trainerBW[1];
      case 5:
        return trainerBW[2];
      case 6:
        return trainerBN[0];
      case 7:
        return trainerBN[1];
      case 8:
        return trainerBN[2];
      case 9:
        return trainerBE[0];
      case 10:
        return trainerBE[1];
      case 11:
        return trainerBE[2];
      default:
        return trainerBS[1];
      }

    }

  }
/**
 * GetPokeman
 * Returns the sprite for the pokeman based on their name.
 * @param name
 * @return BufferedImage The sprite for the pokeman
 */
  public BufferedImage GetPokeman(String name) {
    switch (name) {
    case "Pikachu":
      return pikachuSprite;
    case "Bulbasaur":
      return bulbasaurSprite;
    case "Butterfree":
      return butterfreeSprite;
    case "Eevee":
      return eeveeSprite;
    case "Fearow":
      return fearowSprite;
    case "Kadabra":
      return kadabraSprite;
    case "Mew":
      return mewSprite;
    case "Nidorino":
      return nidorinoSprite;
    case "Sandslash":
      return sandslashSprite;
    case "Arbok":
      return arbokSprite;
    default:
      return pikachuSprite;
    }
  }
  
  
  public BufferedImage GetItem(String name) {
    switch (name) {
    case "Bicycle":
      return bike;
    case "Bracelet":
      return bracelet;
    case "Pokeball":
      return pokeball_item;
    }
    return pokeball_item;
  }
  
  
/**
 * getGroundSprite
 * Returns the sprite of the ground the pokeman stands on in battle
 * @return BufferedImage
 */
  public static BufferedImage getGroundSprite() {
    return groundSprite;
  }
/**
 * setGroundSprite
 * Sets the groundSprite variable as the correct sprite.
 */
  public void setGroundSprite(BufferedImage groundSprite) {
    this.groundSprite = groundSprite;
  }
/**
 * getLogo
 * Returns the logo for the game for the title screen.
 * @return BufferedImage
 */
  public static BufferedImage getLogo() {
    return logo;
  }
}
