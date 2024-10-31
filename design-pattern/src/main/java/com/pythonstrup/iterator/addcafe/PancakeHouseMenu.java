package com.pythonstrup.iterator.addcafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu {
  List<MenuItem> menuItems;

  public PancakeHouseMenu() {
    this.menuItems = new ArrayList<>();

    addItem(
        "K&B",
        "Scrambled Eggs",
        true,
        2.99);
    addItem(
        "Regular",
        "Fried Egg",
        false,
        2.99);
    addItem(
        "Blue berry",
        "Blue berry",
        true,
        3.49);
    addItem(
        "와플",
        "Blue berry & Straw Berry",
        true,
        3.59);
  }

  public void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    menuItems.add(menuItem);
  }

  @Override
  public Iterator<MenuItem> createIterator() {
    return menuItems.iterator();
  }
}
