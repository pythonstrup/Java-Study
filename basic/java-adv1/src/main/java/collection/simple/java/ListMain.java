package collection.simple.java;

import static util.MyLogger.log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListMain {

  public static void main(String[] args) throws InterruptedException {
    List<String> list = new CopyOnWriteArrayList<>();
    Thread thread1 = new Thread(() -> {
      list.add("A");
      log("Thread-1: list.add(A)");
    });
    Thread thread2 = new Thread(() -> {
      list.add("B");
      log("Thread-2: list.add(B)");
    });
    Thread thread3 = new Thread(() -> {
      list.add("C");
      log("Thread-3: list.add(C)");
    });
    thread1.start();
    thread2.start();
    thread3.start();
    thread1.join();
    thread2.join();
    thread3.join();
    System.out.println(list);
  }
}
