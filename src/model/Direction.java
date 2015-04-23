package model;

public enum Direction {

  NORTH(2), SOUTH(0), EAST(1), WEST(3);

  private final int id;

  private Direction(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

}
