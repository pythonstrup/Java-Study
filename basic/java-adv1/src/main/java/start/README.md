## Thread.start()

- `start()`와 `run()`은 무엇이 다른가?

### main에서 `run()` 호출하기

- 아래와 같이 메인서 `run()`을 호출하면 다른 스레드가 아닌 메인 스레드가 직접 작업을 수행하게 된다.
  - bad...

```java
class MyThread {

  public static void main(String[] args) {
    HelloThread thread = new HelloThread();
    thread.run();
  }
}
```

- 따라서 성능을 보장하기 위해 `start()`를 사용해야 한다.

```java
class MyThread {

  public static void main(String[] args) {
    HelloThread thread = new HelloThread();
    thread.start();
  }
}
```

----

## Daemon Thread

### 사용자 스레드와 데몬 스레드

#### 사용자 스레드(Non-daemon Thread)

- 프로그램의 주요 작업을 수행
- 작업이 완료될 때까지 실행
- 모든 user 스레드가 종료되면 JVM도 종료

#### 데몬 스레드

- 백그라운드에서 보조적인 작업을 수행
- 모든 user 스레드가 종료되면 데몬 스레드는 자동으로 종료된다.

> #### 용어 - 데몬
> - 컴퓨터 과학에서는 사용자에게 직접적으로 보이지 않으면서 시스템의 백그라운드에서 작업을 수행하는 것을 데몬 스레드, 데몬 프로세스라 한다.
> - ex) 사용하지 않는 파일이나 메모리 정리하는 작업

### 데몬 스레드 사용하기

```java
MyThread thread = new MyThread();
thread.setDaemon(true); // 데몬 스레드 여부. 지연이 발생해도 백그라운드에서 실행되기 때문에 넘어간다.
```

- daemon 쓰레드에서는 `throws`로 `CheckedException`을 던질 수 없다는 문제가 있으니! 유의!

---

## 쓰레드 생성

1. `Thread` 클래스 상속
2. `Runnable` 인터페이스 구현

```java
MyRunnable runnable = new Runnable();
Thread thread = new Thread(runnable);
thread.start();
```

- 웬만하면 `Runnable`을 사용하자.
  - 상속이 자유롭다.
  - 스레드를 실행할 작업을 분리할 수 있다.
  - 여러 스레드가 동일한 Runnable 객체를 공유할 수 있어 자원 관리에 효율
  - 코드가 약간 복잡해질 수 있다는 단점 (`Thread`에 `Runnable` 전달)

### Runnable과 람다

- `Runnable`은 람다로 손쉽게 만들 수 있다.

```java
Thread thread = new Thread(() -> log("run()"));
thread.start();
```
