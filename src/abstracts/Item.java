package abstracts;

import java.awt.image.BufferedImage;

import model.SpriteLoader;

/**
 * Defines an item. Most items can be used. Items are stored in
 * a Trainer.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public abstract class Item {
/**
 * Item
 * Constructor for the item abstract class
 * 
 * @param name The name of the item
 * @param description A description for the item
 * @param quantity The number of the item the trainer has.
 */
  
  public final SpriteLoader loader = new SpriteLoader();

  public Item(String name, String description, int quantity) {
    super();
    this.name = name;
    Description = description;
    this.quantity = quantity;
  }

  private String name;
  private String Description;
  private int quantity;
/**
 * getName
 * returns the name of the item
 * @return String
 */
  public String getName() {
    return name;
  }
/**
 * getDescription
 * Returns the description of the item
 * @return String
 */
  public String getDescription() {
    return Description;
  }
/**
 * setDescription
 * Sets the description of the item
 * @param description
 */
  public void setDescription(String description) {
    Description = description;
  }
/**
 * getQuantity
 * Returns the quantity of the item the trainer has
 * @return int
 */
  public int getQuantity() {
    return quantity;
  }
/**
 * setQuantity
 * Sets the quantity of the item the trainer has
 * @param quantity
 */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
/**
 * setName
 * Sets the name of the item
 * @param name
 */
  public void setName(String name) {
    this.name = name;
  }
  
  public BufferedImage getSprite() {
    return loader.GetItem(this.getName());
  }

}
