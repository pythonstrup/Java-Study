package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

  private static final int CAPACITY = 10;

  public static void main(String[] args) {
    LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
    System.out.println("buckets = " + Arrays.toString(buckets));
    for (int i = 0; i < CAPACITY; i++) {
      buckets[i] = new LinkedList<>();
    }

    System.out.println("buckets = " + Arrays.toString(buckets));
    add(buckets, 1);
    add(buckets, 2);
    add(buckets, 5);
    add(buckets, 8);
    add(buckets, 14);
    add(buckets, 99);
    add(buckets, 9); // 해시인덱스 중복
    add(buckets, 9); // 값 중복 - 입력 안함
    System.out.println("buckets = " + Arrays.toString(buckets));

    int searchValue = 9;
    boolean contains = contains(buckets, searchValue);
    System.out.println("contains = " + contains);
  }

  private static void add(LinkedList<Integer>[] buckets, int value) {
    int hashIndex = hashIndex(value);
    LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
    if (!bucket.contains(value)) { // O(n)
      bucket.add(value);
    }
  }

  private static boolean contains(LinkedList<Integer>[] buckets, int value) {
    int hashIndex = hashIndex(value);
    LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
    return bucket.contains(value); // O(n)
  }

  static int hashIndex(int value) {
    return value % CAPACITY;
  }
}
