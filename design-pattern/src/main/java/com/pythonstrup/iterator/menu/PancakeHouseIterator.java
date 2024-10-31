package com.pythonstrup.iterator.menu;

import java.util.List;

public class PancakeHouseIterator implements Iterator {
  List<MenuItem> menuItems;
  int position = 0;

  public PancakeHouseIterator(final List<MenuItem> menuItems) {
    this.menuItems = menuItems;
  }

  @Override
  public boolean hasNext() {
    return menuItems.size() > position;
  }

  @Override
  public MenuItem next() {
    return menuItems.get(position++);
  }
}
