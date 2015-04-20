package model;

public class Tile {

  public Tile(int x, int y, char texture, boolean walkable) {
    this.x = x;
    this.y = y;
    this.texture = texture;
    this.walkable = walkable;
  }

  public int x;
  public int y;
  public char texture;
  public boolean walkable;

}
