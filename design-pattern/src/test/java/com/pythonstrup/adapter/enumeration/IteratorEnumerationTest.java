package com.pythonstrup.adapter.enumeration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class IteratorEnumerationTest {

  @Test
  void test() {
    List<Integer> arrays = new ArrayList<>();
    arrays.add(1);
    arrays.add(2);
    arrays.add(3);

    IteratorEnumeration iteratorEnumeration = new IteratorEnumeration(arrays.iterator());
    System.out.println(iteratorEnumeration.nextElement());
    System.out.println(iteratorEnumeration.hasMoreElements());
    System.out.println(iteratorEnumeration.nextElement());
  }
}