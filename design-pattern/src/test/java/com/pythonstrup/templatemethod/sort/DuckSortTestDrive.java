package com.pythonstrup.templatemethod.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DuckSortTestDrive {

  @Test
  void test() {
    Duck[] ducks = {
        new Duck("a", 8),
        new Duck("b", 2),
        new Duck("c", 7),
        new Duck("d", 2),
        new Duck("e", 10),
        new Duck("f", 2)
    };

    System.out.println("정렬 전");
    display(ducks);

    Arrays.sort(ducks);

    System.out.println("\n정렬 후");
    display(ducks);
  }

  private void display(final Duck[] ducks) {
    for (Duck duck: ducks) {
      System.out.println(duck);
    }
  }
}