package com.pythonstrup.templatemethod.sort;

public class Duck implements Comparable<Duck> {

  String name;
  int weight;

  public Duck(final String name, final int weight) {
    this.name = name;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return name + " 체중: " + weight;
  }

  @Override
  public int compareTo(final Duck otherDuck) {
    if (this.weight < otherDuck.weight) {
      return -1;
    }
    if (this.weight == otherDuck.weight) {
      return 0;
    }
    return 1;
  }
}
