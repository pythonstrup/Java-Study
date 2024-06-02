package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmptyListMain {

  public static void main(String[] args) {
    // empty
    List<Integer> list1 = new ArrayList<>();

    // immutable
    List<Integer> list2 = Collections.emptyList(); // java 5
    List<Integer> list3 = List.of(); // java 9

    System.out.println("list2.getClass() = " + list2.getClass());
    System.out.println("list3.getClass() = " + list3.getClass());

    // Arrays.asList
    // java 1.2
    // 이 메소드 대신 List.of 사용 권장
    // 리스트 내부 요소를 변경할 수 있어야 한다면 Arrays.asList를 사용하는 것도 나쁘지 않다.
    List<Integer> list4 = Arrays.asList(1, 2, 3);
    System.out.println("list4.getClass() = " + list4.getClass());

    Integer[] arr = {1,2,3,4,5};
    List<Integer> arrList = Arrays.asList(arr);
    arrList.set(0, 100); // 기존 arr가 바뀐다???
    System.out.println("arr = " + Arrays.toString(arr));
    System.out.println("arrList1 = " + arrList);
    // Arrays.asList 는 배열의 참조값을 그대로 가져다 사용한다!!
    // 엄청나게 큰 배열을 List 자료구조로 변경해야할 때 Arrays.asList로 생성하면 효율적일 수 있다.
  }
}
