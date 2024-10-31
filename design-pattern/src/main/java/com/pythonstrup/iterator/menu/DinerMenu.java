package com.pythonstrup.iterator.menu;

import java.util.Arrays;
import java.util.List;

public class DinerMenu {
  static final int MAX_ITEMS = 6;
  int numberOfItems = 0;
  MenuItem[] menuItems;

  public DinerMenu() {
    this.menuItems = new MenuItem[MAX_ITEMS];

    addItem(
        "채식 BLT",
        "tomato",
        true, 2.99);
    addItem(
        "BLT",
        "tomato",
        true,
        2.99);
    addItem(
        "Soup",
        "potato salad",
        false,
        3.29);
    addItem(
        "Hot dog",
        "onion, cheese",
        false,
        3.05);
  }

  public void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    if (numberOfItems >= MAX_ITEMS) {
      System.err.println("죄송합니다, 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.");
    } else {
      menuItems[numberOfItems] = menuItem;
      numberOfItems = numberOfItems + 1;
    }
  }

  public Iterator createIterator() {
    return new DinerMenuIterator(menuItems);
  }
}
