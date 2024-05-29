package collection.set;

import java.util.Arrays;

public class HashStart4 {

  private static final int CAPACITY = 10;

  public static void main(String[] args) {
    Integer[] inputArray = new Integer[CAPACITY];
    inputArray[hashIndex(1)] = 1;
    inputArray[hashIndex(2)] = 2;
    inputArray[hashIndex(5)] = 5;
    inputArray[hashIndex(8)] = 8;
    inputArray[hashIndex(14)] = 14;
    inputArray[hashIndex(99)] = 99;
    System.out.println("inputArray = " + Arrays.toString(inputArray));

    int searchValue = 14;
    Integer result = inputArray[hashIndex(searchValue)];
    System.out.println("result = " + result);
  }

  static int hashIndex(int value) {
    return value % CAPACITY;
  }
}
