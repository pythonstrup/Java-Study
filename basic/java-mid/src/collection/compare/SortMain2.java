package collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain2 {

  public static void main(String[] args) {
    Integer[] array = {3, 2, 1};
    System.out.println(Arrays.toString(array));

    // asc
    Arrays.sort(array, new AscComparator());
    System.out.println(Arrays.toString(array));

    // desc
    Arrays.sort(array, new DescComparator());
    System.out.println(Arrays.toString(array));
    Arrays.sort(array, new AscComparator().reversed());
    System.out.println(Arrays.toString(array));
  }

  static class AscComparator implements Comparator<Integer> {

    @Override
    public int compare(final Integer o1, final Integer o2) {
      System.out.println("o1=" + o1 + ", o2=" + o2);
      return (o1 < o2) ? -1: ((o1 == o2) ? 0: 1);
    }
  }

  static class DescComparator implements Comparator<Integer> {

    @Override
    public int compare(final Integer o1, final Integer o2) {
      System.out.println("o1=" + o1 + ", o2=" + o2);
      return (o1 < o2) ? -1: ((o1 == o2) ? 0: 1) * -1;
    }
  }
}
