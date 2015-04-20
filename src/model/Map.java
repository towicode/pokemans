package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.Random;

public class Map {

  private final SpriteLoader sprites;
  private Tile backGroundTiles[][] = new Tile[50][30];
  private Tile tiles[][] = new Tile[50][30];

  public Map(SpriteLoader sprites) {

    
    //TODO this is is just a temp map solution
    this.sprites = sprites;
/*    for (int i = 0; i < 30; i++) {
      for (int j = 0; j < 30; j++) {
        tiles[i][j] = new Tile(i * 16, j * 16, 21, true);
      }
    }*/
  }

  public void loadStartingMap() {
    int counter = 0;
    for (int y = 0; y < 30; y++){
      for (int x = 0; x < 50; x++){
        tiles[x][y] = new Tile(x * 16, y * 16, Constants.testMap[counter], true);
        
        counter++;

      }
    }
    // TODO Auto-generated method stub

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
    graphics.setColor(Color.GREEN);
    graphics.fillRect(0, 0, 240, 160);
    for (Tile[] r : tiles) {
      for (Tile k : r) {
        if ((k.x >= -16 && k.x <= 270) && (k.y >= -16 && k.y <= 180)) {

          graphics.drawImage(sprites.getTile(k.texture), k.x, k.y, null);
        }
      }
    }
  }

}
