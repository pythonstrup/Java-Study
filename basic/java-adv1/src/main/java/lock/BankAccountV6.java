package lock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountV6 implements BankAccount {

  private int balance;

  private final Lock lock = new ReentrantLock();

  public BankAccountV6(final int balance) {
    this.balance = balance;
  }

  @Override
  public boolean withdraw(final int amount) {
    log("거래 시작: " + getClass().getSimpleName());

    try {
      if (!lock.tryLock(1500, TimeUnit.MILLISECONDS)) {
        log("[진입 실패] 이미 처리 중인 작업이 있습니다.");
        return false;
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log("[락 획득]");
    // === 임계 영역 시작 ===
    try {
      // 잔고가 출금액 보다 적으면, 진행하면 안 됨.
      log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
      if (balance < amount) {
        log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
        return false;
      }

      // 잔고가 출금액보다 많으면 진행
      log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
      sleep(1000); // 출금에 걸리는 시간으로 가정
      balance -= amount;
      log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
    } finally {
      lock.unlock(); // lock 풀기 (안 풀어주면 무한정 기다리게 된다. 반드시 풀기 위해 try~finally를 활용하자.
      log("[락 반납]");
    }
    // === 임계 영역 종료 ===

    log("거래 종료");
    return true;
  }

  @Override
  public int getBalance() {
    lock.lock();
    try {
      return balance;
    }finally {
      lock.unlock();
    }
  }
}
