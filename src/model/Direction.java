package model;
/**
 * Defines a direction. Trainers can be facing in a direction, and can move in a direction.
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public enum Direction {

  NORTH(2), SOUTH(0), EAST(1), WEST(3);

  private final int id;
  
  private Direction(int id) {
    this.id = id;
  }
/**
 * getId
 * Returns the id of the direction.
 * @return
 */
  public int getId() {
    return id;
  }

}
