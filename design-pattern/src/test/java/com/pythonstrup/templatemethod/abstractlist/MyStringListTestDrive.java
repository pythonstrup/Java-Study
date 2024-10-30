package com.pythonstrup.templatemethod.abstractlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class MyStringListTestDrive {

  @Test
  void test() {
    String[] ducks = {"Mallard Duck", "Redhead Duck", "Rubber Duck", "Decoy Duck"};
    MyStringList ducksList = new MyStringList(ducks);
    System.out.println(ducksList);

    List<String> ducksSubList = ducksList.subList(2, 3);
    System.out.println(ducksSubList);
  }
}