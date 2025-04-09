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

