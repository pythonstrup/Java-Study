package lang.string.builder;

public class LoopStringBuilderMain {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 100_000; i++) {
      sb.append("Hello Java");
    }
    String result = sb.toString();
    long endTime = System.currentTimeMillis();

    System.out.println("result = " + result);
    System.out.println("time = " + (endTime - startTime) + "ms"); // time = 4ms
    // 기존 String을 이어붙이는 것이 2636ms가 걸렸던 것에 비해 StringBuilder는 겨우 4ms만에 작업을 끝냈다.

    // StringBuilder vs StringBuffer
    // 둘의 기능은 같지만 아래와 같은 차이가 있다.
    // StringBuffer: 내부에 동기화가 있어 멀티쓰레드에서 안전하지만 동기화 오버헤드로 인해 느리다.
    // StringBuilder: 동기화가 없어 동기화 오버헤드가 없어 속도가 빠르다. 하지만 멀티쓰레드 상황에서 안전하지 않다.
  }
}
