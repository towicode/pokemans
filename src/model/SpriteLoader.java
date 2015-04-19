package model;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SpriteLoader {

  private boolean loaded = false;

  // tiles
  private BufferedImage dirt;
  private BufferedImage mountain;
  private BufferedImage water;
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

  private BufferedImage mountainNE;
  private BufferedImage mountainNW;
  private BufferedImage mountainSW;
  private BufferedImage mountainSE;
  private BufferedImage mountainN;
  private BufferedImage mountainE;
  private BufferedImage mountainS;
  private BufferedImage mountainW;

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

/*  // player gfx
  private BufferedImage player[];
  private BufferedImage playerY[];
  private BufferedImage playerBicycle[];
*/
  // misc
  private BufferedImage shrub;
  private BufferedImage pokeGrass;
  private BufferedImage stump;
  private BufferedImage rock;
  private BufferedImage pokeball;

  public SpriteLoader() {
    try {
      BufferedImage sheet = ImageIO.read(new File("./resources/tilesheet.png"));
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
      this.dirtW = sheet.getSubimage(96, 16, 16, 16);
      this.dirtE = sheet.getSubimage(64, 16, 16, 16);

      //To be done, can't be fucked to do all this right now.
      /*
       * this.mountainNE = sheet.getSubimage(x, 0, 16, 16); this.mountainNW =
       * sheet.getSubimage(x, 0, 16, 16); this.mountainSW = sheet.getSubimage(x,
       * 32, 16, 16); this.mountainSE = sheet.getSubimage(x, 32, 16, 16);
       * this.mountainN = sheet.getSubimage(x, 0, 16, 16); this.mountainS =
       * sheet.getSubimage(x, 32, 16, 16); this.mountainW = sheet.getSubimage(x,
       * 16, 16, 16); this.mountainE = sheet.getSubimage(x, 16, 16, 16);
       * 
       * this.waterNE = sheet.getSubimage(x, 0, 16, 16); this.waterNW =
       * sheet.getSubimage(x, 0, 16, 16); this.waterSW = sheet.getSubimage(x,
       * 32, 16, 16); this.waterSE = sheet.getSubimage(x, 32, 16, 16);
       * this.waterN = sheet.getSubimage(x, 0, 16, 16); this.waterS =
       * sheet.getSubimage(x, 32, 16, 16); this.waterW = sheet.getSubimage(x,
       * 16, 16, 16); this.waterE = sheet.getSubimage(x, 16, 16, 16);
       * 
       * this.fenceNE = sheet.getSubimage(x, 0, 16, 16); this.fenceNW =
       * sheet.getSubimage(x, 0, 16, 16); this.fenceSW = sheet.getSubimage(x,
       * 32, 16, 16); this.fenceSE = sheet.getSubimage(x, 32, 16, 16);
       * this.fenceN = sheet.getSubimage(x, 0, 16, 16); this.fenceS =
       * sheet.getSubimage(x, 32, 16, 16); this.fenceW = sheet.getSubimage(x,
       * 16, 16, 16); this.fenceE = sheet.getSubimage(x, 16, 16, 16);
       */

      this.loaded = true;
    } catch (Exception e) {
      System.err
          .println("Pokemans could not load it's sprites " + e.toString());
      System.exit(0);
    }
  }
  
  public BufferedImage getTile(char type) {
    switch (type) {
    case '0':
        return dirt;
    case '1':
        return mountain;
    case '2':
        return water;
    case '3':
      return nothing;
    case '4':
      return dirtNE;
    case '5':
      return dirtNW;
    case '6':
      return dirtSW;
    case '7':
      return dirtSE;
    case '8':
      return dirtN;
    case '9':
      return dirtE;
    case 'a':
      return dirtS;
    case 'b':
      return dirtW;
    case 'c':
      return ramp_E_1;
    case 'd':
      return ramp_E_2;
    case 'e':
      return ramp_W_1;
    case 'f':
      return ramp_W_2;
    case 'g':
      return ramp_N_1;
    case 'h':
      return ramp_N_2;
    case 'i':
      return mountainNE;
    case 'j':
      return mountainNW;
    case 'k':
      return mountainSW;
    case 'l':
      return mountainSE;
    case 'm':
      return mountainN;
    case 'n':
      return mountainE;
    case 'o':
      return mountainS;
    case 'p':
      return mountainW;
    case 'q':
      return waterNE;
    case 'r':
      return waterNW;
    case 's':
      return waterSW;
    case 't':
      return waterSE;
    case 'u':
      return waterN;
    case 'v':
      return waterE;
    case 'w':
      return waterS;
    case 'x':
      return waterW;
    case 'y':
      return fenceNE;
    case 'z':
      return fenceNW;
    case '[':
      return fenceSW;
    case ']':
      return fenceSE;
    case ';':
      return fenceE;
    case '/':
      return fenceS;
    case ',':
      return fenceW;    
    case '.':
      return fenceN;
    case '!':
      return shrub;
    case '@':
      return pokeGrass;
    case '#':
      return stump;
    case '$':
      return rock;    
    case '%':
      return pokeball;
    }
    return null;
}

  public BufferedImage getPlayer(int animationSequence, boolean ridingBicycle) {
    // TODO Auto-generated method stub
    return null;
  }

}
