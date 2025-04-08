package sync.test;

import static util.MyLogger.log;

public class SyncTest2Main {

  public static void main(String[] args) {
    MyCounter myCounter = new MyCounter();

    Runnable task = new Runnable() {
      @Override
      public void run() {
        myCounter.count();
      }
    };

    Thread t1 = new Thread(task, "t1");
    Thread t2 = new Thread(task, "t2");

    t1.start();
    t2.start();
  }

  static class MyCounter {

    // 지역 변수는 동시성 문제가 발생하지 않는다.
    // 각 스레드의 스택에 담기는 값이기 때문!
    public void count() {
      int localValue = 0;
      for (int i = 0; i < 10_000; i++) {
        localValue++;
      }
      log("결과: " + localValue);
    }
  }
}
