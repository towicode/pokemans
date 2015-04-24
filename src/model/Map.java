package model;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Defines a map. The map is made up of Tiles. These can be background tiles, object tiles, or grass tiles.
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public class Map {

  private final SpriteLoader sprites;
  private Tile backGroundTiles[][] = new Tile[50][30];
  private Tile tiles[][] = new Tile[50][30];
  private Tile grassTiles[][] = new Tile[50][30];

  private int tileX;
  private int tileY;

  public Map(SpriteLoader sprites) {

    // TODO this is is just a temp map solution
    this.sprites = sprites;
    /*
     * for (int i = 0; i < 30; i++) { for (int j = 0; j < 30; j++) { tiles[i][j]
     * = new Tile(i * 16, j * 16, 21, true); } }
     */
  }

  public void loadStartingMap() {
    int counter = 0;
    for (int y = 0; y < 30; y++) {
      for (int x = 0; x < 50; x++) {
        tiles[x][y] = new Tile(x * 16, y * 16, Constants.testMap[counter], true);
        backGroundTiles[x][y] = new Tile(x * 16, y * 16,
            Constants.testMap_base[counter], true);
        grassTiles[x][y] = new Tile(x * 16, y * 16,
            Constants.testMap_grass[counter], true);
        counter++;
      }
    }

    // TODO make this less ghetto:
    adjustUp();
    adjustUp();
    adjustUp();
    adjustUp();
    adjustUp();
    adjustUp();
    adjustUp();
    adjustUp();

    // starting location
    tileX = 7;
    tileY = 7;

  }

  public void adjustRight() {

    for (Tile[] r : tiles) {
      for (Tile k : r) {
        k.x = k.x + 4;
      }
    }

    for (Tile[] r : backGroundTiles) {
      for (Tile k : r) {
        k.x = k.x + 4;
      }
    }

    for (Tile[] r : grassTiles) {
      for (Tile k : r) {
        k.x = k.x + 4;
      }
    }
  }

  public void adjustLeft() {

    for (Tile[] r : tiles) {
      for (Tile k : r) {
        k.x = k.x - 4;
      }
    }

    for (Tile[] r : backGroundTiles) {
      for (Tile k : r) {
        k.x = k.x - 4;
      }
    }

    for (Tile[] r : grassTiles) {
      for (Tile k : r) {
        k.x = k.x - 4;
      }
    }
  }

  public void adjustUp() {

    for (Tile[] r : tiles) {
      for (Tile k : r) {
        k.y = k.y - 4;
      }
    }

    for (Tile[] r : backGroundTiles) {
      for (Tile k : r) {
        k.y = k.y - 4;
      }
    }

    for (Tile[] r : grassTiles) {
      for (Tile k : r) {
        k.y = k.y - 4;
      }
    }
  }

  public void adjustDown() {

    for (Tile[] r : tiles) {
      for (Tile k : r) {
        k.y = k.y + 4;
      }
    }

    for (Tile[] r : backGroundTiles) {
      for (Tile k : r) {
        k.y = k.y + 4;
      }
    }

    for (Tile[] r : grassTiles) {
      for (Tile k : r) {
        k.y = k.y + 4;
      }
    }
  }

  public void draw(Graphics2D graphics) {
    
    
    //TODO this is only for the demo, there is absolutely no reason to have three for loops here. Figure out a way to do this better.
    
    for (Tile[] o : backGroundTiles) {
      if ((o[0].x <= -16 || o[0].x >= 270)) // This should help reduce CPU a
                                            // little
        continue;
      for (Tile k : o) {
        if ((k.x >= -16 && k.x <= 270) && (k.y >= -16 && k.y <= 180)) {
          if (k.texture != 0)
            graphics.drawImage(sprites.getTile(k.texture), k.x, k.y, null);
        }
      }
    }

    for (Tile[] r : tiles) {
      if ((r[0].x <= -16 || r[0].x >= 270))
        continue;
      for (Tile k : r) {
        if ((k.x >= -16 && k.x <= 270) && (k.y >= -16 && k.y <= 180)) {
          if (k.texture != 0)
            graphics.drawImage(sprites.getTile(k.texture), k.x, k.y, null);
        }
      }
    }

    for (Tile[] o : grassTiles) {
      if ((o[0].x <= -16 || o[0].x >= 270)) 
        continue;
      for (Tile k : o) {
        if ((k.x >= -16 && k.x <= 270) && (k.y >= -16 && k.y <= 180)) {
          if (k.texture != 0)
            graphics.drawImage(sprites.getTile(k.texture), k.x, k.y, null);
        }
      }
    }
  }

  public Tile[][] getTiles() {
    return tiles;
  }

  public void setTiles(Tile[][] tiles) {
    this.tiles = tiles;
  }

}
