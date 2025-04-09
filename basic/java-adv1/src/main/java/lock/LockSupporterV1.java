package lock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.locks.LockSupport;

public class LockSupporterV1 {

  public static void main(String[] args) {
    Thread t1 = new Thread(new ParkTest(), "t1");
    t1.start();

    sleep(100);
    log("t1 state: " + t1.getState());

    log("main -> unpark(t1)");
    LockSupport.unpark(t1); // 1. unpark() 사용
    // t1.interrupt(); // 2. interrupt() 사용 - unpark()와 동일하게 스레드를 깨운다.
  }

  static class ParkTest implements Runnable {

    @Override
    public void run() {
      log("park 시작");
      LockSupport.park();
      log("park 종료, state: " + Thread.currentThread().getState());
      log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
    }
  }
}
