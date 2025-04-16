package cas.increment;

import static util.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.List;

public class IncrementPerformanceMain {

  public static final int COUNT = 100_000_000;

  public static void main(String[] args) throws InterruptedException {
    test(new BasicInteger());
    test(new VolatileInteger());
    test(new SyncInteger());
    test(new MyAtomicInteger());
  }

  private static void test(IncrementInteger incrementInteger) throws InterruptedException {
    long startMs = System.currentTimeMillis();

    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < COUNT; i++) {
      incrementInteger.increment();
    }

    long endMs = System.currentTimeMillis();
    System.out.println(incrementInteger.getClass().getSimpleName() + ": " + (endMs - startMs) + "ms");
  }
}
