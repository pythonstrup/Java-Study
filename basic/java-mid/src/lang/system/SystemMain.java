package lang.system;

import java.util.Arrays;
import java.util.Map;

public class SystemMain {

  public static void main(String[] args) {
    long currentTimeMillis = System.currentTimeMillis();
    System.out.println("currentTimeMillis = " + currentTimeMillis);

    long currentTimeNano = System.nanoTime();
    System.out.println("currentTimeNano = " + currentTimeNano);

    // 환경 변수를 읽는다. (운영체제에서 사용하는 것)
    System.out.println("getevn=" + System.getenv());

    // 시스템 속성을 읽는다. (자바에서 사용하는 것)
    System.out.println("properties = " + System.getProperties());
    System.out.println("Java version: " + System.getProperty("java.version"));

    // 배열을 고속으로 복사
    // 시스템 레벨에서(운영체제나 하드웨어 레벨) 최적화된 메모리 복사 연산을 사용. 배열을 통째로 복사해버리기 때문에 빠름 (최소 2배에서 5배 정도 빠르다고 함)
    // 애플리케이션 단에서는 루프를 돌려서 복사하기 때문에 상대적으로 느림.
    char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
    char[] copiedArray = new char[5];
    System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
    System.out.println("copiedArray = " + copiedArray);
    System.out.println("copiedArray = " + Arrays.toString(copiedArray));

    // 프로그램 종료
    System.exit(0);
    System.out.println("hello"); // 위에서 종료되기 때문에 실행이 되지 않음
  }
}
