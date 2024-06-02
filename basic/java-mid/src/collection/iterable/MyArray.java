package collection.iterable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer> {

  private int[] numbers;

  public MyArray(final int[] numbers) {
    this.numbers = numbers;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new MyArrayIterator(numbers);
  }
}
