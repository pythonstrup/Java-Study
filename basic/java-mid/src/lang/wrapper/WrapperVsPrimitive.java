package lang.wrapper;

public class WrapperVsPrimitive {

  // 분명 Primitive가 Wrapper 타입보다 빠르지만..
  // 쓸데없는 최적화를 위해 Wrapper를 Primitive로 바꾸진 말자!
  public static void main(String[] args) {
    int iterations = 1_000_000_000;
    long startTime, endTime;

    // primitive
    long sumPrimitive = 0;
    startTime = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      sumPrimitive += i;
    }
    endTime = System.currentTimeMillis();
    System.out.println("sumPrimitive = " + sumPrimitive);
    System.out.println("기본 자료형 long 실행 시간: " + (endTime - startTime) + "ms");
    // result: 369ms

    // Wrapper
    Long sumWrapper = 0L;
    startTime = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      sumWrapper += i;
    }
    endTime = System.currentTimeMillis();
    System.out.println("sumPrimitive = " + sumWrapper);
    System.out.println("래퍼 클래스 Long 실행 시간: " + (endTime - startTime) + "ms");
    // result: 1612ms
  }
}
