package collection.simple;

import static util.MyLogger.log;

import collection.simple.list.BasicList;
import collection.simple.list.SimpleList;

public class SimpleListMainV2 {

  public static void main(String[] args) throws InterruptedException {
    test(new BasicList());
  }

  private static void test(final SimpleList list) throws InterruptedException {
    log(list.getClass().getSimpleName());

    Runnable task1 = () -> {
      list.add("A");
      log("Thread-1: list.add(A)");
    };

    Runnable task2 = () -> {
      list.add("B");
      log("Thread-2: list.add(B)");
    };

    Thread thread1 = new Thread(task1, "Thread-1");
    Thread thread2 = new Thread(task2, "Thread-2");
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    log(list);
  }
}
