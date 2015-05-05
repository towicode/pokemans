package model;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SpriteLoader {

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
  
  private BufferedImage pikachuSprite;

  // main-guy sheet

  private BufferedImage trainerN[] = new BufferedImage[3];
  private BufferedImage trainerS[] = new BufferedImage[3];
  private BufferedImage trainerE[] = new BufferedImage[3];
  private BufferedImage trainerW[] = new BufferedImage[3];

  public SpriteLoader() {
    try {
      BufferedImage sheet = ImageIO.read(new File("./resources/tilesheet.png"));
      pikachuSprite = ImageIO.read(new File("./resources/PokemonSprites/pikachu80x80.png ") );

      this.ramp_E_1 = sheet.getSubimage(0, 0, 16, 16);
      this.ramp_E_2 = sheet.getSubimage(0, 16, 16, 16);
      this.ramp_W_1 = sheet.getSubimage(16, 0, 16, 16);
      this.ramp_W_2 = sheet.getSubimage(16, 16, 16, 16);
      this.ramp_N_1 = sheet.getSubimage(0, 32, 16, 16);
      this.ramp_N_2 = sheet.getSubimage(16, 32, 16, 16);
      this.shrub = sheet.getSubimage(32, 0, 16, 16);
      this.pokeGrass = sheet.getSubimage(32, 16, 16, 16);
      this.rock = sheet.getSubimage(32, 32, 16, 16);
      this.stump = sheet.getSubimage(48, 32, 16, 16);
      this.pokeball = sheet.getSubimage(48, 16, 16, 16);
      this.dirt = sheet.getSubimage(80, 16, 16, 16);
      this.dirtNE = sheet.getSubimage(96, 0, 16, 16);
      this.dirtNW = sheet.getSubimage(64, 0, 16, 16);
      this.dirtSW = sheet.getSubimage(64, 32, 16, 16);
      this.dirtSE = sheet.getSubimage(96, 32, 16, 16);
      this.dirtN = sheet.getSubimage(80, 0, 16, 16);
      this.dirtS = sheet.getSubimage(80, 32, 16, 16);
      this.dirtW = sheet.getSubimage(64, 16, 16, 16);
      this.dirtE = sheet.getSubimage(96, 16, 16, 16);

      // To be done, can't be fucked to do all this right now.

      this.grass = sheet.getSubimage(128, 16, 16, 16);
      this.mountainNE = sheet.getSubimage(144, 0, 16, 16);
      this.mountainNW = sheet.getSubimage(112, 0, 16, 16);
      this.mountainSW = sheet.getSubimage(112, 32, 16, 16);
      this.mountainSE = sheet.getSubimage(144, 32, 16, 16);
      this.mountainN = sheet.getSubimage(128, 0, 16, 16);
      this.mountainS = sheet.getSubimage(128, 32, 16, 16);
      this.mountainW = sheet.getSubimage(112, 16, 16, 16);
      this.mountainE = sheet.getSubimage(144, 16, 16, 16);

      this.water = sheet.getSubimage(176, 16, 16, 16);
      this.waterNE = sheet.getSubimage(192, 0, 16, 16);
      this.waterNW = sheet.getSubimage(160, 0, 16, 16);
      this.waterSW = sheet.getSubimage(160, 32, 16, 16);
      this.waterSE = sheet.getSubimage(192, 32, 16, 16);
      this.waterN = sheet.getSubimage(176, 0, 16, 16);
      this.waterS = sheet.getSubimage(176, 32, 16, 16);
      this.waterW = sheet.getSubimage(160, 16, 16, 16);
      this.waterE = sheet.getSubimage(192, 16, 16, 16);

      this.nothing = sheet.getSubimage(224, 16, 16, 16);
      this.fenceNE = sheet.getSubimage(240, 0, 16, 16);
      this.fenceNW = sheet.getSubimage(208, 0, 16, 16);
      this.fenceSW = sheet.getSubimage(208, 32, 16, 16);
      this.fenceSE = sheet.getSubimage(240, 32, 16, 16);
      this.fenceN = sheet.getSubimage(224, 0, 16, 16);
      this.fenceS = sheet.getSubimage(224, 32, 16, 16);
      this.fenceW = sheet.getSubimage(208, 16, 16, 16);
      this.fenceE = sheet.getSubimage(240, 16, 16, 16);

      BufferedImage Psheet = ImageIO.read(new File(
          "./resources/trainerSheet.png"));

      trainerN[0] = Psheet.getSubimage(0, 0, 16, 16);
      trainerN[1] = Psheet.getSubimage(16, 0, 16, 16);
      trainerN[2] = Psheet.getSubimage(32, 0, 16, 16);

      trainerE[0] = Psheet.getSubimage(0, 16, 16, 16);
      trainerE[1] = Psheet.getSubimage(16, 16, 16, 16);
      trainerE[2] = Psheet.getSubimage(32, 16, 16, 16);

      trainerS[0] = Psheet.getSubimage(0, 32, 16, 16);
      trainerS[1] = Psheet.getSubimage(16, 32, 16, 16);
      trainerS[2] = Psheet.getSubimage(32, 32, 16, 16);

      trainerW[0] = Psheet.getSubimage(0, 48, 16, 16);
      trainerW[1] = Psheet.getSubimage(16, 48, 16, 16);
      trainerW[2] = Psheet.getSubimage(32, 48, 16, 16);

      this.loaded = true;
    } catch (Exception e) {
      System.err
          .println("Pokemans could not load it's sprites " + e.toString());
      System.exit(0);
    }
  }

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

  public BufferedImage getPlayer(int animationSequence, boolean ridingBicycle) {
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
  }
  
  public BufferedImage GetPokeman(String name) {
	  switch(name) {
	  case "Pikachu":
		  return pikachuSprite;
	  default: 
		  return pikachuSprite;
	  }
  }
}
