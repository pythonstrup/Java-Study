package virtual.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadIoBound {

  private static final int NUMBER_OF_TASKS = 10_000;

  public static void execute() {
    System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

    long start = System.currentTimeMillis();
    performTasks();
//    performTasksContextSwitch();
    System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
  }

  // 2087ms
  private static void performTasks() {
    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < NUMBER_OF_TASKS; i++) {
        executorService.submit(() -> blockingIoOperation());
      }
    }
  }

  public static void blockingIoOperation() {
    System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
    try {
      Thread.sleep(1_000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  // 9528ms => 마찬가지로 문맥교환으로 인해 시간이 더 소요되지만 기존의 스레드 방식보다 빠르다.
  private static void performTasksContextSwitch() {
    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < NUMBER_OF_TASKS; i++) {
        for (int j = 0; j < 100; j++) {
          executorService.submit(() -> blockingIoOperation());
        }
      }
    }
  }

  public static void blockingIoOperationContextSwitch() {
    System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
