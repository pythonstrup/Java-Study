package collection.simple.list;

import static util.ThreadUtils.sleep;

import java.util.Arrays;

public class SyncList implements SimpleList{

  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public SyncList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  @Override
  public synchronized int size() {
    return size;
  }

  @Override
  public synchronized void add(final Object e) {
    elementData[size] = e;
    sleep(100); // 멀티스레드 문제를 확인하기 위한 코드
    size++;
  }

  @Override
  public synchronized Object get(final int index) {
    return elementData[index];
  }

  @Override
  public synchronized String toString() {
    return "list=" + Arrays.toString(Arrays.copyOf(elementData, size))
        + ", size=" + size +  ", capacity=" + elementData.length;
  }
}
