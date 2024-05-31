package collection.set.javaset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class JavaSetMain {

  public static void main(String[] args) {
    Set<String> hashSet = new HashSet<>();
    Set<String> linkedHashSet = new LinkedHashSet<>();
    Set<String> treeSet = new TreeSet<>();
    // 자바의 자동 최적화 기능
    // HashSet의 같은 hashIndex를 가진 아이템이 약 8개 정도가 넘어가면
    // 해당 index 배열의 자료구조를 LinkedList에서 트리구조로 변경한다고 함.

    run(hashSet);
    run(linkedHashSet);
    run(treeSet);
  }

  private static void run(Set<String> set) {
    System.out.println("set.getClass() = " + set.getClass());

    set.add("C");
    set.add("B");
    set.add("A");
    set.add("1");
    set.add("2");

    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
  }
}
