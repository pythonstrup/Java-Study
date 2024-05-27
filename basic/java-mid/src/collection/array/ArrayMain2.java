package collection.array;

import java.util.Arrays;

public class ArrayMain2 {

  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[0] = 1;
    arr[1] = 2;
    System.out.println(Arrays.toString(arr));

    // 배열의 첫번째 위치에 추가
    // 기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 첫번째 위치에 추가
    System.out.println("배열의 첫번째 위치에 3을 추가 O(n)");
    int newValue = 3;
    addFirst(arr, newValue);
    System.out.println(Arrays.toString(arr));

    // index 위치에 추가
    // 기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 인덱스 위치에 추가
    System.out.println("배열의 인덱스 위치에 4를 추가 O(n)");
    int index = 2;
    int value = 4;
    addAtIndex(arr, index, value);
    System.out.println(Arrays.toString(arr));

    // 마지막 위치에 추가
    // 기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 마지막 위치에 추가
    System.out.println("배열의 마지막 위치에 5를 추가 O(1)");
    addLast(arr, 5);
    System.out.println(Arrays.toString(arr));
  }

  private static void addFirst(final int[] arr, final int newValue) {
    for (int i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i-1];
    }
    arr[0] = newValue;
  }

  private static void addAtIndex(final int[] arr, final int index, final int value) {
    for (int i = arr.length - 1; i > index; i--) {
      arr[i] = arr[i-1];
    }
    arr[index] = value;
  }

  private static void addLast(final int[] arr, final int newValue) {
    arr[arr.length - 1] = newValue;
  }
}
