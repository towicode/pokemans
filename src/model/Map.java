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

  private static final int TILE_SIZE = 16;

  private static final int MAP_WIDTH = 50;

  private static final int MAP_HEIGHT = 30;

  private final SpriteLoader sprites;

  private Tile backGroundTiles[][] = new Tile[MAP_WIDTH][MAP_HEIGHT];
  private Tile tiles[][] = new Tile[MAP_WIDTH][MAP_HEIGHT];
  private Tile grassTiles[][] = new Tile[MAP_WIDTH][MAP_HEIGHT];
  private int grassTileRaw[]; // used for IsInGrass
  private int id;
/**
 * Map
 * Constructor for Map. 
 * @param sprites The sprite sheet for the map.
 */
  public Map(SpriteLoader sprites) {

    this.sprites = sprites;

  }
/**
 * LoadThirdMap
 * Loads map 3
 * @param up_offset
 * @param down_offset
 * @param left_offset
 * @param right_offset
 */
  public void LoadThirdMap(int up_offset, int down_offset, int left_offset,
      int right_offset) {
    int counter = 0;
    for (int y = 0; y < MAP_HEIGHT; y++) {
      for (int x = 0; x < MAP_WIDTH; x++) {
        tiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE, Constants.flatMap[counter], true);
        backGroundTiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE,
            Constants.flatMap_base[counter], true);
        grassTiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE,
            Constants.flatMap_grass[counter], true);
        counter++;
      }
    }
    for (int i = 0; i < up_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustUp();
      }
    }
    for (int i = 0; i < down_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustDown();
      }
    }
    for (int i = 0; i < left_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustLeft();
      }
    }
    for (int i = 0; i < right_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustRight();
      }
    }

    this.setGrassTileRaw(Constants.flatMap_grass); // used for IsInGrass
    this.id = 3;

  }
/**
 * LoadSecondMap
 * Loads map 2
 * @param up_offset
 * @param down_offset
 * @param left_offset
 * @param right_offset
 */
  public void LoadSecondMap(int up_offset, int down_offset, int left_offset,
      int right_offset) {
    int counter = 0;
    for (int y = 0; y < MAP_HEIGHT; y++) {
      for (int x = 0; x < MAP_WIDTH; x++) {
        tiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE, Constants.waterMap[counter],
            true);
        backGroundTiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE,
            Constants.waterMap_base[counter], true);
        grassTiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE,
            Constants.waterMap_grass[counter], true);
        counter++;
      }
    }

    for (int i = 0; i < up_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustUp();
      }
    }
    for (int i = 0; i < down_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustDown();
      }
    }
    for (int i = 0; i < left_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustLeft();
      }
    }
    for (int i = 0; i < right_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustRight();
      }
    }

    this.setGrassTileRaw(Constants.waterMap_grass); // used for IsInGrass
    this.id = 2;

  }
/**
 * loadStartingMap
 * Loads the first map
 * @param up_offset
 * @param down_offset
 * @param left_offset
 * @param right_offset
 */
  public void loadStartingMap(int up_offset, int down_offset, int left_offset,
      int right_offset) {
    int counter = 0;
    for (int y = 0; y < MAP_HEIGHT; y++) {
      for (int x = 0; x < MAP_WIDTH; x++) {
        tiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE, Constants.testMap[counter], true);
        backGroundTiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE,
            Constants.testMap_base[counter], true);
        grassTiles[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE,
            Constants.testMap_grass[counter], true);
        counter++;
      }
    }

    for (int i = 0; i < up_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustUp();
      }
    }
    for (int i = 0; i < down_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustDown();
      }
    }
    for (int i = 0; i < left_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustLeft();
      }
    }
    for (int i = 0; i < right_offset; i++) {
      for (int j = 0; j < 4; j++) {
        adjustRight();
      }
    }

    this.setGrassTileRaw(Constants.testMap_grass); // used for IsInGrass
    this.id = 1;
  }
/**
 * adjustRight
 * Adjusts the map right by an offset
 */
  public void adjustRight() {

    for (int y = 0; y < MAP_HEIGHT; y++)
      for (int x = 0; x < MAP_WIDTH; x++) {
        tiles[x][y].x = tiles[x][y].x + 4;
        backGroundTiles[x][y].x = backGroundTiles[x][y].x + 4;
        grassTiles[x][y].x = grassTiles[x][y].x + 4;
      }

  }
  /**
   * adjustLeft
   * Adjusts the map left by an offset
   */
  public void adjustLeft() {

    for (int y = 0; y < MAP_HEIGHT; y++)
      for (int x = 0; x < MAP_WIDTH; x++) {
        tiles[x][y].x = tiles[x][y].x - 4;
        backGroundTiles[x][y].x = backGroundTiles[x][y].x - 4;
        grassTiles[x][y].x = grassTiles[x][y].x - 4;
      }
  }
  /**
   * adjustUp
   * Adjusts the map up by an offset
   */
  public void adjustUp() {

    for (int y = 0; y < MAP_HEIGHT; y++)
      for (int x = 0; x < MAP_WIDTH; x++) {
        tiles[x][y].y = tiles[x][y].y - 4;
        backGroundTiles[x][y].y = backGroundTiles[x][y].y - 4;
        grassTiles[x][y].y = grassTiles[x][y].y - 4;
      }
  }
  /**
   * adjustDown
   * Adjusts the map down by an offset
   */
  public void adjustDown() {

    for (int y = 0; y < MAP_HEIGHT; y++)
      for (int x = 0; x < MAP_WIDTH; x++) {
        tiles[x][y].y = tiles[x][y].y + 4;
        backGroundTiles[x][y].y = backGroundTiles[x][y].y + 4;
        grassTiles[x][y].y = grassTiles[x][y].y + 4;
      }
  }
/**
 * draw
 * Draws the map on the screen
 * @param graphics
 */
  public void draw(Graphics2D graphics) {

    for (int y = 0; y < MAP_HEIGHT; y++)
      for (int x = 0; x < MAP_WIDTH; x++) {
        Tile temp = tiles[x][y];
        Tile bgtemp = backGroundTiles[x][y];
        Tile grasstemp = grassTiles[x][y];
        if ((temp.x >= -TILE_SIZE && temp.x <= Constants.FRAME_WIDTH + TILE_SIZE)
            && (temp.y >= -TILE_SIZE && temp.y <= Constants.FRAME_HEIGHT + TILE_SIZE)) {

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
/**
 * getTiles
 * return the array of tiles representing the map
 * @return Tile[][]
 */
  public Tile[][] getTiles() {
    return tiles;
  }
/**
 * setTIles
 * sets the tiles for the map to a given tile array
 * @param tiles
 */
  public void setTiles(Tile[][] tiles) {
    this.tiles = tiles;
  }
/**
 * getGrassTileRaw
 * returns the grass tiles for the map as an int array
 * @return int
 */
  public int[] getGrassTileRaw() {
    return grassTileRaw;
  }
/**
 * setGrassTileRaw
 * Sets this maps grassTileRaw array to a given array
 * @param grassTileRaw[]
 */
  public void setGrassTileRaw(int grassTileRaw[]) {
    this.grassTileRaw = grassTileRaw;
  }
/**
 * getId
 * Return the id of the map
 * @return int
 */
  public int getId() {
    return id;
  }

}
