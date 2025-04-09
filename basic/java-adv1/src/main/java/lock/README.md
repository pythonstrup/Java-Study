# LockSupport

## synchronized 단점

- `무한 대기`: `BLOCKED` 상태의 스레드는 락이 풀릴 때까지 무한 대기한다.
- `공정성`: 락이 돌아왔을 때 `BLOCKED` 상태의 여러 스레드 중에 어떤 스레드가 락을 획득할 지 알 수 없다. 최악의 경우 특정 스레드가 너무 오랜기간 락을 획득하지 못할 수 있다.
- 이런 문제를 해결하기 위해 자바 1.5부터 `java.util.concurrent`라는 동시성 문제를 해결하기 위한 라이브러리 패키지가 추가되었다.

## LockSupport 기능

- `LockSupport`는 스레드를 `WAITING` 상태로 변경한다.
  - `WAITING` 상태는 누가 깨워주기 전까지는 계속 대기한다. 그리고 CPU 실행 스케줄링에 들어가지 않는다.
- `LockSupport`의 대표적인 기능
  - `park()`: 스레드를 `WAITING` 상태로 변경한다.
  - `parkNanos(nanos)`: 스레드를 나노초 동안만 `TIMED_WAITING` 상태로 변경한다.
    - 지정한 나노초가 지나면 `TIMED_WAITING` 상태에서 빠져나오고 `RUNNABLE` 상태로 변경된다.
  - `unpark(thread)`: `WAITING` 상태의 대상 스레드를 `RUNNABLE` 상태로 변경한다.

## `BLOCKED` vs `WAITING`

- `WAITING` 상태에 특정 시간까지만 대기하는 기능이 포함된 것이 `TIME_WAITING`이다.

### 인터럽트

- `BLOCKED` 상태는 인터럽트가 걸려도 대기 상태를 빠져나오지 못한다. 계속 `BLOCKED` 상태다.
- `WAITING`, `TIME_WAITING`는 대기 상태에서 빠져나오고 `RUNNABLE`로 전환한다.

### 용도

- `BLOCKED` 상태는 자바의 `synchronized`에서 락을 획득하기 위해 대기할 때 사용
- `WAITING`, `TIME_WAITING` 상태는 스레드가 특정 조건이나 시간 동안 대기할 때 발생하는 상태.
- `WAITING`는 다양하게 활용
  - `Thread.join()`, `LockSupport.park()`, `Object.wait()` => `WAITING` 상태로 만듦
- `TIME_WAITING`
  - `Thread.sleep(ms)`, `Object.wait(long timeout)`, `Thread.join(long millis)`, `LockSupport.parkNanos(ns)` 등과 같은 시간 제한이 있는 대기 메소드를 호출할 때 발생

### 대기 상태(`WAITING`)와 시간 대기 상태(`TIME_WAITING`)는 서로 짝이 있다.

- `Thread.join()`, `Thread.join(long millis)`
- `Thread.park()`, `Thread.parkNanos(long millis)`
- `Object.wait()`, `Object.wait(long timeout)`

### 정리

- 인터럽트를 받아서 스레드를 깨울 수 있다는 점!
- 이런 기능을 잘 활용하면! `synchronized`의 단점인 무한 대기 문제를 해결할 수 있다!
  - `parkNanos(ns)` 활용!

- 임계 영역 만드는 방법

```java
if (!lock.tryLock(10초)) { // 내부에서 parkNanos() 사용
  return false;
}

// 임계 영역 시작
...
// 임계 영역 종료
lock.unlock(); // 내부에서 unpark() 사용
```

- 하지만 이런 기능을 직접 구현하는 건 매우 어렵다.
  - 자료구조 필요.
  - 우선순위 문제.
- 이런 기능을 위해 `Lock` 인터페이스와 `ReentrantLock` 구현체를 제공한다!!!

---

# ReentrantLock

- since Java 1.5

## Lock 인터페이스

```java
public interface Lock {
  
    void lock();
    void lockInterruptibly() throws InterruptedException;
    boolean tryLock();
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
    void unlock();
    Condition newCondition();
}
```

- `void lock()`: 락을 획득. 다른 스레드가 이미 락을 획득했다면, 락이 풀릴 때까지 `대기 WAITING`한다.
  - 이 메소드는 인터럽트에 응답하지 않는다.
- `void lockInterruptibly()`: 락 획득을 시도하되, 다른 스레드가 인터럽트할 수 있도록 한다. 다른 스레드가 이미 락을 획득했다면, 현재 스레드는 락을 획득할 때까지 대기한다.
  - 대기 중에 인터럽트가 발생하면 `InterruptedException`이 발생하며 락 획득을 포기한다.
- `boolean tryLock()`: 락 획득 시도, 즉시 성공 여부 반환.
  - 다른 스레드가 락을 이미 획득했다면 false를 반환하고, 바로 포기해버린다.
- `boolean tryLock(long time, TimeUnit unit)`: 주어진 시간 동안 락 획득을 시도. 주어진 시간 안에 락을 획득하면 `true`를 반환.
  - 락을 획득하지 못하면 `false`를 반환하고 락 포기.
  - 대기 중에 인터럽트가 발생하면 `InterruptedException`이 발생하며 락 획득을 포기한다.
- `void unlock()`: 락을 해제.
  - 대기 중인 스레드가 락을 획득할 수 있게 된다.
  - 락을 획득한 스레드가 호출해야 하며, 락이 없는 스레드가 호출하면 `IllegalMonitorStateException`이 발생한다.
- `Condition newCondition()`: `Condition` 객체를 생성하여 반환.
  - `Condition`은 락과 결합되어 사용되며, 스레드가 특정 조건을 기다리거나 신호를 받을 수 있도록 한다.
  - `Object`클래스의 `wait`, `notify`, `notifyAll` 메소드와 유사한 역할

> #### 참고
> - `lock()`을 호출해서 대기 중일 때, 인터럽트를 하면?
> - 순간적으로 `WAITING` -> `RUNNABLE`로 상태가 바뀌며 대기 상태를 빠져나오지만! `lock()` 메소드가 강제로 `WAITING` 상태로 바꿔버린다.
>   - 이런 원리로 인터럽트를 무시!

## 공정성

- `ReentrantLock`은 스레드가 공정하게 락을 얻을 수 있는 모드를 제공한다.

```java
new ReentrantLock(true);
```

- 공정 모드는 속도가 살짝 느릴 수 있다. 대신 기아 현상을 방지한다.

## 대기 중간

- 락을 무한정 대기하지 않고, 중간에 빠져나오는 것이 가능하다.
  - `tryLock()`, `tryLock(long time, TimeUnit unit)`



