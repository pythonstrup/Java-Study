package collection.array;

import java.util.Arrays;

public class ArrayListV4<E> {

  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public ArrayListV4() {
    // 타입 이레이저 때문에 new E 사용이 불가하다.
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayListV4(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  public int size() {
    return size;
  }

  public void add(E e) {
    // 코드 추가
    if (size == elementData.length) {
      grow();
    }
    elementData[size] = e;
    size++;
  }

  // 코드 추가
  public void add(int index, E e) {
    if (size == elementData.length) {
      grow();
    }
    // 데이터 이동
    shiftRightFrom(index);
    elementData[index] = e;
    size++;
  }

  // 코드 추가
  // 요소의 마막부터 index까지 오른쪽으로 밀기
  private void shiftRightFrom(final int index) {
    for (int i = size; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }
  }

  private void grow() {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity * 2;

    // 배열을 새로 만들고, 기존 배열을 새로운 배열에 복사
//    Object[] newArr = new Object[newCapacity];
//    for (int i = 0; i < elementData.length; i++) {
//      newArr[i] = elementData[i];
//    }
//    elementData = newArr;

    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    return (E) elementData[index];
  }

  public E set(int index, E element) {
    E oldValue = get(index);
    elementData[index] = element;
    return oldValue;
  }

  // 코드 추가
  public E remove(int index) {
    E oldValue = get(index);
    shiftLeftFrom(index); // 데이터 이동
    elementData[--size] = null;
    return oldValue;
  }

  // 코드 추가
  // 요소의 index부터 마지막까지 왼쪽으로 밀기
  private void shiftLeftFrom(final int index) {
    for (int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }
  }

  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (o.equals(elementData[i])) {
        return i;
      }
    }
    return -1;
  }

  public String toString() {
    return Arrays.toString(Arrays.copyOf(elementData, size))
        + " size=" + size
        + ", capacity=" + elementData.length;
  }
}
