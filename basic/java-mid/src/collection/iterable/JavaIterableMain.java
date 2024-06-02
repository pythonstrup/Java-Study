package collection.iterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class JavaIterableMain {

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);
    set.add(3);

    printAll(list.iterator());
    printAll(set.iterator());
    
    printForEach(list);
    printForEach(set);
  }

  private static void printAll(Iterator<Integer> iterator) {
    System.out.println("iterator.getClass() = " + iterator.getClass());
    while (iterator.hasNext()) {
      System.out.println("iterator.next() = " + iterator.next());
    }
    System.out.println();
  }

  private static void printForEach(Iterable<Integer> iterable) {
    System.out.println("iterable.getClass() = " + iterable.getClass());
    for(Integer value: iterable) {
      System.out.println("value = " + value);
    }
    System.out.println();
  }
}
