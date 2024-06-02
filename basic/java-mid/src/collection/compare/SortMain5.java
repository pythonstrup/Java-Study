package collection.compare;

import java.util.Set;
import java.util.TreeSet;

public class SortMain5 {

  public static void main(String[] args) {
    MyUser myUser1 = new MyUser("a", 30);
    MyUser myUser2 = new MyUser("b", 20);
    MyUser myUser3 = new MyUser("c", 10);

    Set<MyUser> set1 = new TreeSet<>();
    set1.add(myUser1);
    set1.add(myUser2);
    set1.add(myUser3);
    // 트리에 들어가는 순간부터 comparable 기본 정렬이 이뤄진다.
    System.out.println(set1);

    // 트리 set을 생성할 때 comparator를 전달해 정렬 기준을 정할 수 있다.
    Set<MyUser> set2 = new TreeSet<>(new IdComparator());
    set2.add(myUser1);
    set2.add(myUser2);
    set2.add(myUser3);
    System.out.println(set2);
  }
}
