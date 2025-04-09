package lock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.locks.LockSupport;

public class LockSupporterV2 {

  public static void main(String[] args) {
    Thread t1 = new Thread(new ParkTest(), "t1");
    t1.start();

    sleep(100);
    log("t1 state: " + t1.getState());
  }

  static class ParkTest implements Runnable {

    @Override
    public void run() {
      log("park 시작");
      LockSupport.parkNanos(2_000_000_000); // 2초
      log("park 종료, state: " + Thread.currentThread().getState());
      log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
    }
  }
}
