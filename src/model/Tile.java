package model;
/**
 * Defines a map tile. The tile has an x and y coordinate, a texture, and can be walked though or not.
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public class Tile {
	  /**
	   * Tile(int x, int y, int i, boolean walkable)
	   * 
	   * Constructor for the Tile class. 
	   * 
	   * @param x The x coordinate for the tile in the map.
	   * @param y The y coordinate for the tile in the map.
	   * @param i The number of the texture for the tile.
	   * @param walkable Wether or not the tile can be walkedo n by a trainer.
	   */
  public Tile(int x, int y, int i, boolean walkable) {
    this.x = x;
    this.y = y;
    this.texture = i;
    this.walkable = walkable;
  }

  public int x;
  public int y;
  public int texture;
  public boolean walkable;

}
