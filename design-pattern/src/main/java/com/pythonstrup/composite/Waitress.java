package com.pythonstrup.composite;

public class Waitress {

  MenuComponent allMenus;

  public Waitress(final MenuComponent allMenus) {
    this.allMenus = allMenus;
  }

  public void printMenu() {
    allMenus.print();
  }
}
