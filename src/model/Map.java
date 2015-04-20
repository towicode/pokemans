package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.Random;

public class Map {

  private final SpriteLoader sprites;
  private Tile tiles[][] = new Tile[30][30];

  public Map(SpriteLoader sprites) {

    
    //TODO this is is just a temp map solution
    this.sprites = sprites;
    for (int i = 0; i < 30; i++) {
      for (int j = 0; j < 30; j++) {
        tiles[i][j] = new Tile(i * 16, j * 16, 'a', true);
      }
    }
  }

  public void loadStartingMap() {
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

    for (Tile[] r : tiles) {
      for (Tile k : r) {
        if ((k.x >= -16 && k.x <= 270) && (k.y >= -6 && k.y <= 180)) {
          graphics.drawImage(sprites.getTile(k.texture), k.x, k.y, null);
        }
      }
    }
  }

}
