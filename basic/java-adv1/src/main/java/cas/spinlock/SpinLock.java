package cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {

  private final AtomicBoolean lock = new AtomicBoolean();

  public void lock() {
    log("락 획득 시도");
    while (!lock.compareAndSet(false, true)) { // CAS 연산을 사용해 원자적인 연산으로 바꿨다!
      log("락 획득 실패 - 스핀 대기");
    }
    log("락 획득 완료");
  }

  public void unlock() {
    lock.set(false);
    log("락 반납 완료");
  }
}
