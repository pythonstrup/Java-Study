package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncMain {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println("list.getClass() = " + list.getClass());
    List<Integer> synchronizedList = Collections.synchronizedList(list);
    System.out.println("synchronizedList.getClass() = " + synchronizedList.getClass());
    // 일반 스레드를 멀티스레드 상황에서 동기화 문제가 발생하지 않는 안전한 리스트로 만들 수 있다.
    // 대신 동기화 작업으로 인해 일반 리스트보다 성능은 더 느리다.
  }
}
