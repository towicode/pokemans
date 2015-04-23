package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Map {

  private final SpriteLoader sprites;
  private Tile backGroundTiles[][] = new Tile[50][30]; // TODO instead of the
                                                       // green square
  private Tile tiles[][] = new Tile[50][30];

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
        counter++;
      }
    }
  }

  public void adjustRight() {

    for (Tile[] r : tiles) {
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
  }

  public void adjustUp() {

    for (Tile[] r : tiles) {
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
  }

  public void draw(Graphics2D graphics) {
    for (Tile[] r : tiles) {
      if ((r[0].x <= -16 || r[0].x >= 270)) //This should help reduce CPU a little
        continue;
      for (Tile k : r) {
        if ((k.x >= -16 && k.x <= 270) && (k.y >= -16 && k.y <= 180)) {

          graphics.drawImage(sprites.getTile(k.texture), k.x, k.y, null);
        }
      }
    }
  }

}
