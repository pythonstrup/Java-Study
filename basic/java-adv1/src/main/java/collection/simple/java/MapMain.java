package collection.simple.java;

import static util.MyLogger.log;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class MapMain {

  public static void main(String[] args) throws InterruptedException {
    thread(new ConcurrentHashMap<>());
    thread(new ConcurrentSkipListMap<>());
  }

  private static void thread(Map<String, String> map) throws InterruptedException {
    Thread thread1 = new Thread(() -> {
      map.put("3", "C");
      log("Thread-1: map.put(3, C)");
    });
    Thread thread2 = new Thread(() -> {
      map.put("1", "B");
      log("Thread-2: map.put(1, B)");
    });
    Thread thread3 = new Thread(() -> {
      map.put("2", "A");
      log("Thread-3: map.put(2, A)");
    });
    thread1.start();
    thread2.start();
    thread3.start();
    thread1.join();
    thread2.join();
    thread3.join();
    System.out.println(map);
  }
}
