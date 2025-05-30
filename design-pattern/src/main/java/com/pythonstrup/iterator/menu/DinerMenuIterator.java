package com.pythonstrup.iterator.menu;

public class DinerMenuIterator implements Iterator {

  MenuItem[] items;
  int position = 0;

  public DinerMenuIterator(final MenuItem[] items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    if (position >= items.length || items[position] == null) {
      return false;
    }
    return true;
  }

  @Override
  public MenuItem next() {
    MenuItem menuItem = items[position];
    position = position + 1;
    return menuItem;
  }
}
