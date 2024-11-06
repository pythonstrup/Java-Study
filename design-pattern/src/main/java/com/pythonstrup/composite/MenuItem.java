package com.pythonstrup.composite;

public class MenuItem extends MenuComponent {

  String name;
  String description;
  boolean vegetarian;
  double price;

  public MenuItem(final String name, final String description, final boolean vegetarian,
      final double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public void print() {
    System.out.print("  " + getName());
    if (isVegetarian()) {
      System.out.print("(v)");
    }
    System.out.println(", " + getPrice());
    System.out.println("      __ " + getDescription());
  }
}
