package atomic;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class AtomicReferenceStackObject {

  // -49,764,881 operations were performed in 10 seconds
  // => 연산 숫자가 너무 커서 오버플로우가 발생할 지경
  public static void executeLockFree() throws InterruptedException {
    LockFreeStack<Integer> stack = new LockFreeStack<>();
    Random random = new Random();

    for (int i = 0; i < 100_000; i++) {
      stack.push(random.nextInt());
    }

    ArrayList<Thread> threads = new ArrayList<>();

    int pushingThreads = 2;
    int poppingThreads = 2;

    for (int i = 0; i < pushingThreads; i++) {
      Thread thread = new Thread(() -> {
        while (true) {
          stack.push(random.nextInt());
        }
      });
      thread.setDaemon(true);
      threads.add(thread);
    }

    for (int i = 0; i < poppingThreads; i++) {
      Thread thread = new Thread(() -> {
        while (true) {
          stack.pop();
        }
      });
      thread.setDaemon(true);
      threads.add(thread);
    }

    for (Thread thread: threads) {
      thread.start();
    }
    Thread.sleep(10_000);
    System.out.println(String.format("%,d operations were performed in 10 seconds ", stack.getCounter()));
  }

  // 274,175,564 operations were performed in 10 seconds
  public static void executeStandard() throws InterruptedException {
    StandardStack<Integer> stack = new StandardStack<>();
    Random random = new Random();

    for (int i = 0; i < 100_000; i++) {
      stack.push(random.nextInt());
    }

    ArrayList<Thread> threads = new ArrayList<>();

    int pushingThreads = 2;
    int poppingThreads = 2;

    for (int i = 0; i < pushingThreads; i++) {
      Thread thread = new Thread(() -> {
        while (true) {
          stack.push(random.nextInt());
        }
      });
      thread.setDaemon(true);
      threads.add(thread);
    }

    for (int i = 0; i < poppingThreads; i++) {
      Thread thread = new Thread(() -> {
        while (true) {
          stack.pop();
        }
      });
      thread.setDaemon(true);
      threads.add(thread);
    }

    for (Thread thread: threads) {
      thread.start();
    }
    Thread.sleep(10_000);
    System.out.println(String.format("%,d operations were performed in 10 seconds ", stack.getCounter()));
  }

  private static class LockFreeStack<T> {
    private AtomicReference<StackNode<T>> head = new AtomicReference<>();
    private AtomicLong counter = new AtomicLong(0);

    public synchronized void push(T value) {
      StackNode<T> newHeadNode = new StackNode<>(value);

      while (true) {
        StackNode<T> currentHeadNode = head.get();
        newHeadNode.next = currentHeadNode;
        if (head.compareAndSet(currentHeadNode, newHeadNode)) {
          break;
        } else {
          LockSupport.parkNanos(1);
        }
      }
      counter.incrementAndGet();
    }

    public synchronized T pop() {
      StackNode<T> currentHeadNode = head.get();
      StackNode<T> newHeadNode;

      while(currentHeadNode != null) {
        newHeadNode = currentHeadNode.next;
        if (head.compareAndSet(currentHeadNode, newHeadNode)) {
          break;
        } else {
          LockSupport.parkNanos(1);
          currentHeadNode = head.get();
        }
      }
      counter.decrementAndGet();
      return currentHeadNode != null ? currentHeadNode.value : null;
    }

    public long getCounter() {
      return counter.get();
    }
  }

  public static class StandardStack<T> {
    private StackNode<T> head;
    private int counter = 0;

    public synchronized void push(T value) {
      StackNode<T> newHead = new StackNode<>(value);
      newHead.next = head;
      head = newHead;
      counter++;
    }

    public synchronized T pop() {
      if (head == null) {
        counter++;
        return null;
      }

      T value = head.value;
      head = head.next;
      counter++;
      return value;
    }

    public int getCounter() {
      return counter;
    }
  }

  private static class StackNode<T> {
    public T value;
    public StackNode<T> next;

    public StackNode(T value) {
      this.value = value;
      this.next = next;
    }
  }
}
