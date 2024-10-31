package com.pythonstrup.iterator.addcafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu implements Menu {
  Map<String, MenuItem> menuItems = new HashMap<>();

  public CafeMenu() {
    addItem(
        "Burger",
        "Burger",
        true,
        3.99);
    addItem(
        "soup",
        "soup",
        false,
        3.69);
    addItem(
        "burrito",
        "burrito",
        true,
        4.29);
  }

  public void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    menuItems.put(name, menuItem);
  }

  @Override
  public Iterator<MenuItem> createIterator() {
    return menuItems.values().iterator();
  }
}
