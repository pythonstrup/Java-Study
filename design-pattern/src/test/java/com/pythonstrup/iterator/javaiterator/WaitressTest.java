package com.pythonstrup.iterator.javaiterator;

import static org.junit.jupiter.api.Assertions.*;

import com.pythonstrup.iterator.menu.DinerMenu;
import com.pythonstrup.iterator.menu.PancakeHouseMenu;
import com.pythonstrup.iterator.menu.Waitress;
import org.junit.jupiter.api.Test;

class WaitressTest {

  @Test
  void test() {
    com.pythonstrup.iterator.menu.PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    com.pythonstrup.iterator.menu.DinerMenu dinerMenu = new DinerMenu();

    com.pythonstrup.iterator.menu.Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

    waitress.printMenu();
  }
}