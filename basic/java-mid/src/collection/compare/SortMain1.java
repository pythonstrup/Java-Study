package collection.compare;

import java.util.Arrays;

public class SortMain1 {

  public static void main(String[] args) {
    Integer[] array = {3, 2, 1};
    System.out.println(Arrays.toString(array));

    Arrays.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
