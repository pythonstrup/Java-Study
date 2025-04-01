# 스레드 제어

## 스레드의 기본 정보

- `thread.threadId()`: 스레드 ID
- `thread.getName()`: 스레드 이름. 주로 디버깅이나 로깅 목적.
- `thread.getPriority()`: 스레드 우선 순위 => 운영체제 스케줄러에게 힌트를 준다. (조금이라도 자주 실행됨.)
  - 1~10. 기본값 `5`, `setPriority()`로 설정 가능.
- `thread.getThreadGroup()`: 스레드가 속한 그룹
- `thread.getState()`: 상태
    - `NEW`: 아직 시작되지 않은 상태.
    - `RUNNABLE`: 실행 중이거나 실행될 준비가 된 상태.
    - `BLOCKED`: 동기화 락을 기다리는 상태.
    - `WAITING`: 스레드가 다른 스레드의 특정 작업이 완료되기를 기다리는 상태
    - `TIMED_WAITING`: 일정 시간 동안 기다리는 상태
    - `TERMINATED`: 스레드가 실행을 마친 상태

## join

### join은 언제 필요한가?

- 스레드의 종료 후 결과값이 보장되어야 할 때!

```java
thread.start();
thread.join(); // 스레드가 종료될 때까지 기다린다.

logic();
```

- `join()`을 하면 부모 thread는 `WAITING` 상태가 된다.

### join - 특정 시간 만큼만 대기

- `join(long millis)`에 `millis`를 전달하면 그만큼 대기한다.

```java
thread.start();
thread.join(); // 스레드가 종료될 때까지 기다린다.

logic();
```
