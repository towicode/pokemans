package model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Defines a map. The map is made up of Tiles. These can be background tiles,
 * object tiles, or grass tiles.
 * 
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
  private int grassTileRaw[]; // used for IsInGrass
  private int id;

  public Map(SpriteLoader sprites) {

    this.sprites = sprites;

  }

  public void LoadThirdMap() {
    int counter = 0;
    for (int y = 0; y < 30; y++) {
      for (int x = 0; x < 50; x++) {
        tiles[x][y] = new Tile(x * 16, y * 16, Constants.flatMap[counter], true);
        backGroundTiles[x][y] = new Tile(x * 16, y * 16,
            Constants.flatMap_base[counter], true);
        grassTiles[x][y] = new Tile(x * 16, y * 16,
            Constants.flatMap_grass[counter], true);
        counter++;
      }
    }
    this.setGrassTileRaw(Constants.flatMap_grass); // used for IsInGrass
    this.id = 3;

  }

  public void LoadSecondMap() {
    int counter = 0;
    for (int y = 0; y < 30; y++) {
      for (int x = 0; x < 50; x++) {
        tiles[x][y] = new Tile(x * 16, y * 16, Constants.waterMap[counter],
            true);
        backGroundTiles[x][y] = new Tile(x * 16, y * 16,
            Constants.waterMap_base[counter], true);
        grassTiles[x][y] = new Tile(x * 16, y * 16,
            Constants.waterMap_grass[counter], true);
        counter++;
      }
    }
    this.setGrassTileRaw(Constants.waterMap_grass); // used for IsInGrass
    this.id = 2;

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
    this.setGrassTileRaw(Constants.testMap_grass); // used for IsInGrass
    this.id = 1;
  }

  public void adjustRight() {

    for (int y = 0; y < 30; y++)
      for (int x = 0; x < 50; x++) {
        tiles[x][y].x = tiles[x][y].x + 4;
        backGroundTiles[x][y].x = backGroundTiles[x][y].x + 4;
        grassTiles[x][y].x = grassTiles[x][y].x + 4;
      }

  }

  public void adjustLeft() {

    for (int y = 0; y < 30; y++)
      for (int x = 0; x < 50; x++) {
        tiles[x][y].x = tiles[x][y].x - 4;
        backGroundTiles[x][y].x = backGroundTiles[x][y].x - 4;
        grassTiles[x][y].x = grassTiles[x][y].x - 4;
      }
  }

  public void adjustUp() {

    for (int y = 0; y < 30; y++)
      for (int x = 0; x < 50; x++) {
        tiles[x][y].y = tiles[x][y].y - 4;
        backGroundTiles[x][y].y = backGroundTiles[x][y].y - 4;
        grassTiles[x][y].y = grassTiles[x][y].y - 4;
      }
  }

  public void adjustDown() {

    for (int y = 0; y < 30; y++)
      for (int x = 0; x < 50; x++) {
        tiles[x][y].y = tiles[x][y].y + 4;
        backGroundTiles[x][y].y = backGroundTiles[x][y].y + 4;
        grassTiles[x][y].y = grassTiles[x][y].y + 4;
      }
  }

  public void draw(Graphics2D graphics) {

    for (int y = 0; y < 30; y++)
      for (int x = 0; x < 50; x++) {
        Tile temp = tiles[x][y];
        Tile bgtemp = backGroundTiles[x][y];
        Tile grasstemp = grassTiles[x][y];
        if ((temp.x >= -16 && temp.x <= 270)
            && (temp.y >= -16 && temp.y <= 180)) {

          if (bgtemp.texture != 0) {
            graphics.drawImage(sprites.getTile(bgtemp.texture), bgtemp.x,
                bgtemp.y, null);
          }
          if (temp.texture != 0) {
            graphics.drawImage(sprites.getTile(temp.texture), temp.x, temp.y,
                null);
          }
          if (grasstemp.texture != 0) {
            graphics.drawImage(sprites.getTile(grasstemp.texture), grasstemp.x,
                grasstemp.y, null);
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

  public int[] getGrassTileRaw() {
    return grassTileRaw;
  }

  public void setGrassTileRaw(int grassTileRaw[]) {
    this.grassTileRaw = grassTileRaw;
  }

  public int getId() {
    return id;
  }

}
