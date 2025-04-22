# 동시성 컬렉션

- 컬렉션 프레임워크가 제공하는 대부분의 연산은 원자적인 연산이 아니다.
  - `ArrayList`, `LinkedList`, `HashSet`, `HashMap` 등
  - `add()`가 원자적인 연산처럼 느껴질 수 있겠지만, 그 내부에서는 수 많은 연산들이 함께 사용된다.
  - 배열에 데이터를 추가하고, 배열을 새로 만들어서 배열의 크기도 늘리고, 노드를 만들어서 링크에 연결하는 등.
- 따라서, `Thread-safe` 하지 않다.
  - 멀티스레드 환경에서라면 `java.util` 패키지가 제공하는 일반적인 컬렉션을 사용하면 안 된다.
  - 결과적으로 값을 넣을 때 동시에 실행되면, element 값이 사라져 버릴 수 있다.

## 동기화

- 그럼 `synchronized`를 쉽게 해결될 것이다.
- 하지만? 이렇게 되면 모든 컬렉션을 다 복사해서 동기화 용으로 새로 구현해야하므로 매우 비효율적.

## 프록시 도입

- `ArrayList`, `LinkedList`, `HashSet`, `HashMap` 등에 모두 동기화를 적용한 코드를 만들고 싶다면?
- 프록시 객체로 대리해서 처리할 수 있다. 

> #### 프록시
> - 대리자, 대신 처리해주는 자.
> - 주요 목적
> 1. 접근 제어: 실제 객체에 대한 접근을 제한하거나 통제
> 2. 성능 향상: 실제 객체의 생성을 지연시키거나 캐싱하여 성능을 최적화
> 3. 부가 기능 제공: 실제 객체에 추가적인 기능(로깅, 인증, 동기화 등)을 투명하게 제공

```java
public class SyncProxyList implements SimpleList {

  SimpleList target;

  public SyncProxyList(final SimpleList target) {
    this.target = target;
  }

  @Override
  public synchronized 메소드() {...}
}
```

---

# 자바 동시성 컬렉션

- 동기화의 필요성을 정확히 판단하고 꼭 필요한 경우에만 동기화를 적용하는 것이 필요하다.

> #### `java.util.Vector`
> - 과거 자바는 실수를 한 번 했다.
> - 이 클래스는 이미 동기화가 다 적용되어 있다. (`synchronized`가 다 걸려 있다.)
> - 이에 따라 단일 스레드 환경에서도 불필요한 동기화로 성능이 저하되었고, 결과적으로 `Vector`는 널리 사용하지 않게 되었다.
> - 지금은 하위 호환을 위해 남아 있을 뿐...

## `Collections.synchronizedXxx()`

- `Collections`는 다양한 `synchronized` 동기화 메소드를 지원한다. `List`, `Collection`, `Map`, `Set` 등 다양한 동기화 프록시를 만들어낼 수 있다.
  - ex) `Collections.synchronizedList()`

### synchronized 프록시 방식의 단점

1. 동기화 오버헤드 (`synchronized` 자체의 오버헤드가 있다.)
2. 전체 컬렉션에 대한 동기화. 잠금 범위가 넓다.
3. 정교한 동기화 불가능. 특정 부분에 대한 동기화 적용이 어렵다.

- 자바는 이런 단점을 보완하기 위해 `java.util.concurrent` 패키지에 `동시성 컬렉션 concurrent collection`을 제공한다.

## `java.util.concurrent`

- 고성능 멀티스레드 환경을 지원하는 다양한 동시성 컬렉션 클래스 제공
  - ex) `ConcurrentHashMap`, `CopyOnWriteArrayList`, `BlockingQueue` 등
- 정교한 잠금 메커니즘을 사용하여 동시 접근을 효율적으로 처리하며, 필요한 경우 일부 메소드에 대해서만 동기화를 적용하는 등 유연하 동기화 전략을 제공한다.
  - `synchronized`, `Lock(ReentrantLock)`, `CAS`, `분할 잠금 기술 segment lock` 등 다양한 방법을 섞어서 매우 정교한 동기화를 구현하면서 동시에 성능도 최적화.

> #### 분할 잠금 기술
> - `ConcurrentHashMap`과 같은 경우, 해시 버킷 단위로 락이 걸리게 된다.
>   - 해시 충돌이 발생하는 값끼리만 동시성이 보장되면 되기 때문이다!
> - 이때 사용되는 기술이 `segment lock`이다.

### 동시성 컬렉션의 종류

- 참고로 `LinkedHashSet`과 `LinkedHashMap`처럼 입력 순서를 유지하는 동시에 멀티스레드 환경에서 사용할 수 있는 `Set`, `Map` 구현체는 제공하지 않는다.
  - 필요하다면 `Collections.synchronizedXxx()`를 활용해야 한다.

#### `List`

- `CopyOnWriteArrayList`: `ArrayList` 대안

#### `Set`

- `CopyOnWriteArraySet`: `HashSet` 대안
- `ConcurrentSkipListSet`: `TreeSet` 대안

#### `Map`

- `ConcurrentHashMap`: `HashMap` 대안
- `ConcurrentSkipListMap`: `TreeMap` 대안

#### `Queue`

- `ConcurrentLinkedQueue`: 동시성 큐, `non-blocking queue`

#### `Deque`

- `ConcurrentLinkedDeque`: 동시성 데크, `non-blocking deque`

#### `BlockingQueue`

- 스레드를 차단하는 블로킹 큐

- `ArrayBlockingQueue`: 크기 고정. 공정 모드 사용 가능
- `LinkedBlockingQueue`: 크기가 무한하거나, 고정된 큐
- `PriorityBlockingQueue`: 우선순위가 높은 요소를 먼저 처리하는 블로킹 큐
- `SynchronousQueue`: 데이터를 저장하지 않는 블로킹 큐. 생산자가 데이터를 추가하면 소비자가 그 데이터를 받을 때까지 대기. 생산자-소비자 간의 직접적인 `핸드오프 hand-off` 메커니즘을 제공. (중간에 큐 없이 생산자, 소비자가 직접 거래하는 거라고 생각하면 된다.)
- `DelayQueue`: 지연된 요소를 처리하는 블로킹 큐. 각 요소는 지정된 지연 시간이 지난 후에야 소비될 수 있다. 일정 시간이 지난 후 작업을 처리해야 하는 스케줄링 작업에 사용된다.

----

## 정리

- 자바가 제공하는 동시성 컬렉션은 멀티스레드 상황에서 최적의 성능을 낼 수 있도록 다양한 최적화 기법이 적용되어 있다.
  - 따라서 `Collections.synchronizedXxx`를 사용하는 것보다 더 좋은 성능을 제공한다.
- 동시성은 결국 성능과 트레이드 오프가 있다.
- 따라서 단일 스레드가 컬렉션을 사용하는 경우에는 동시성 컬렉션이 아닌 일반 컬렉션을 사용해야 한다.

