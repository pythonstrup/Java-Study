package collection.simple.java;

import static util.MyLogger.log;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {

  public static void main(String[] args) throws InterruptedException {
    thread(new CopyOnWriteArraySet<>());
    thread(new ConcurrentSkipListSet());
  }

  private static void thread(Set set) throws InterruptedException {
    Thread thread1 = new Thread(() -> {
      set.add("C");
      log("Thread-1: set.add(C)");
    });
    Thread thread2 = new Thread(() -> {
      set.add("B");
      log("Thread-2: set.add(B)");
    });
    Thread thread3 = new Thread(() -> {
      set.add("A");
      log("Thread-3: set.add(A)");
    });
    thread1.start();
    thread2.start();
    thread3.start();
    thread1.join();
    thread2.join();
    thread3.join();
    System.out.println(set);
  }
}
