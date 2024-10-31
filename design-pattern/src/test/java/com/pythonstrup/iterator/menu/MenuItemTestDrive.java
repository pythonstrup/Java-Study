package com.pythonstrup.iterator.menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuItemTestDrive {

  @Test
  void test() {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    Iterator menuItems = pancakeHouseMenu.createIterator();
    while (menuItems.hasNext()) {
      System.out.println(menuItems.next());
    }
  }
}