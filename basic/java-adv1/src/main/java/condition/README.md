# Lock Condition

- 생산자가 생산자를 깨우고, 소비자가 소비자를 깨우는 비효율 문제를 어떻게 해결할 수 있을까?

## 해결 방안

- 핵심은 생산자 스레드는 데이터를 생성하고, 대기 중인 소비자 스레드에게 알려줘야 한다.
- 반대로 소비자 스레드는 데이터를 소비하고, 대기 중인 생산자 스레드에게 알려주면 된다.
- 결국 스레드 대기 집합을 각각 나누면 된다! 그럼 대기 집합은 어떻게 분리할 수 있을까? => `Lock`과 `ReentrantLock`을 사용하면 된다.

## `ReentrantLock`에서의 Condition 활용

- lock에서 대기 집합 생성

```java
private final Condition condition = lock.newCondition();
```

- 락에서 기다리게 만들기
  - `Object.wait()`와 동일한 역할

```java
condition.await();
```

- 깨우기
  - `Object.notify()`와 동일한 역할

```java
condition.signal();
```

### 대기 공간 분리하기

```java
private final Condition producerCond = lock.newCondition(); // 생산자 대기 집합
private final Condition consumerCond = lock.newCondition(); // 소비자 대기 집합
```

- 생산자가 생산할 때 가득차면 기다리게 하기, 그리고 생산 완료되면 소비자 깨우기

```java
// .. 생산 코드 ..
while (queue.size() == max) {
  // ...
  producerCond.await(); // 생산자 기다리게 하기
  // ...
}
// ...
consumerCond.signal(); // 소비자 깨우기
```

- 소비자가 소비할 때 비어 있으면 기다리게 하기, 그리고 소비하면 생산자 깨우기

```java
// .. 소비 코드 ..
while (queue.isEmpty()) {
  // ...
  consumerCond.await(); // 소비자 기다리게 하기
  // ...
}
// ...
producerCond.signal(); // 생산자 깨우기
```

### `Object.notify()` vs `Condition.signal()`

#### `Object.notify()`

- 대기 중인 스레드 중 임의의 하나를 선택해서 깨운다. 순서 정의 X, 순서는 JVM 구현에 따라 다름. 보통은 먼저 들어온 스레드가 먼저 수행되지만 구현에 따라 다를 수 있다.
- `synchronized` 블록 내에서 모니터 락을 가지고 있는 스레드가 호출해야 한다.

#### `Condition.signal()`

- 대기 중인 스레드 중 하나를 깨우며, 일반적으로 FIFO 순서로 깨운다. 이 부분은 자바 버전과 구현에 따라 달라질 수 있지만, 보통 `Condition`의 구현은 `Queue` 구조를 사용하기 때문에 FIFO 순서로 깨운다.
- `ReentrantLock`을 가지고 있는 스레드가 호출해야 한다.

---

# 스레드의 대기

- 스레드를 대기를 구현하기 위해 2단계 대기소를 가지고 있다.

## `synchronized`의 대기 상태

### 대기1: 락 획득 대기

- `BLOCKED` 상태로 락 획득 대기.
- `synchronized`를 시작할 때 락이 없으면 대기.
- 다른 스레드가 락을 놓아주면(`synchronized` 블록에서 빠져나가면) 대기 풀림.

### 대기2: `wait()` 대기

- `WAITING` 상태로 대기
- `wait()`를 호출했을 때 스레드 대기 집합에서 대기
- `notify()` 호출되면 대기 풀림.

### `synchronized` 락 대기 집합

- 자바 내부에 구현되어 있기 때문에 모니터 락과 같이 개발자가 확인하기는 어렵다.
  - `BLOCKED` 상태로 대기하는 스레드 대기 집합
- 스레드 대기 집합과는 다른 개념이다.

## `ReentrantLock`의 대기

- `Lock`(`ReentrantLock`)도 2가지 단계의 대기 상태가 존재한다.

### 대기1: 락 획득 대기

- `WAITING` 상태로 대기
- `ReentrantLock`의 대기 큐에서 관리
- `lock.lock()`을 호출했을 때 락이 없으면 대기
- 다른 스레드가 `lock.unlock()`을 호출하면 대기가 풀리고 락 획득 시도. 락을 획득하면 대기 큐를 빠져나감.

### 대기2: await() 대기

- `WAITING` 상태로 대기
- `condition.await()`를 호출했을 때, `condition` 객체의 스레드 대기 공간에서 관리
- 다른 스레드가 `condition.signal()`을 호출했을 때, `condition` 객체의 스레드 대기 공간에서 빠져나감.