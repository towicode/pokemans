package model;

import java.util.ArrayList;

import abstracts.Item;
/**
 * Defines an inventory. An inventory belongs to a Trainer. It is an ArrayList of items. 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public class Inventory {

  ArrayList<Item> items;

  public Inventory() {
    items = new ArrayList<Item>();
  }
}
