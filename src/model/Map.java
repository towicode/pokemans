package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Map {

  private final SpriteLoader sprites;
  private Tile tiles[] = new Tile[20 * 20];

  public Map(SpriteLoader sprites) {
    
    this.sprites = sprites;
    // TODO Auto-generated constructor stub
  }

  public void loadStartingMap() {
    // TODO Auto-generated method stub

  }

  public void draw(Graphics2D graphics) {

    for (int x = 0; x < 20; x++) {
      for (int y = 0; y < 20; y++) {
        graphics.setColor(Color.YELLOW);
        graphics.drawImage(sprites.getTile('0'), x * 16, y * 16, null);
        //graphics.drawRect(x * 16, y * 16, 16, 16);
      }
    }

    // TODO Auto-generated method stub

  }

}
