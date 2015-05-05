package abstracts;

/**
 * Defines an item. Most items can be used. Items are stored in the Inventory of
 * a Trainer.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public abstract class Item {

  public Item(String name, String description, int quantity) {
    super();
    this.name = name;
    Description = description;
    this.quantity = quantity;
  }

  private String name;
  private String Description;
  private int quantity;

  public String getName() {
    return name;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setName(String name) {
    this.name = name;
  }

}
