package model;

public class Tile {

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
