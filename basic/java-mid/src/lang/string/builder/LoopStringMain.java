package lang.string.builder;

public class LoopStringMain {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    String result = "";
    // JDK 5버전 이전 버전은 + 연산자를 사용해 String을 이어붙이면 각각 new String()을 사용해 객체를 생성했기 때문에 속도가 느렸다.
    // 하지만 JDK 5버전부터 + 연산자를 사용하면 자동으로 StringBuilder를 사용한다.
    for (int i = 0; i < 100_000; i++) {
      result += "Hello Java"; // => result = new StringBuilder().append(result).append("Hello Java ").toString() 과 동일함
      // 따라서 반복문에서 결국 객체가 반복 생성되기 때문에 StringBuilder 자동 최적화는 의미가 없다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println("result = " + result);
    System.out.println("time = " + (endTime - startTime) + "ms"); // time = 2636ms
  }
}
