package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 3);

    // change to mutable
    ArrayList<Integer> mutableList = new ArrayList<>(list);
    mutableList.add(1);
    System.out.println("mutableList = " + mutableList);
    System.out.println("mutableList.getClass() = " + mutableList.getClass());

    // change to immutable
    List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
    System.out.println("unmodifiableList = " + unmodifiableList);
    System.out.println("unmodifiableList.getClass() = " + unmodifiableList.getClass());
//    unmodifiableList.add(5); // error
  }
}
