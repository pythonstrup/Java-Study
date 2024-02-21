package io;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 스레드는 비싼 리소스이다. (메모리와 자원을 소비하기 때문)
// 너무 많은 스레드가 많들어지면 메모리나 자원이 부족해 프로그램이 터진다.
public class IoBound {

  private static final int NUMBER_OF_TASKS = 10_000;

  public static void execute() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Press enter to start");
    scanner.nextLine();

    System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

    long start = System.currentTimeMillis();
//    performTasks();
    performTasksContextSwitch();
    System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
  }

  // 10106ms 소요
  private static void performTasks() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(1_000)) {
      for (int i = 0; i < NUMBER_OF_TASKS; i++) {
        executorService.submit(() ->  blockingIoOperation());
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

  // 15069ms 소요
  // IO 시간은 적지만, 각 작업마다 99번의 문맥 교환이 일어나기 때문에 더 많은 시간이 소요된다.
  private static void performTasksContextSwitch() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(1_000)) {
      for (int i = 0; i < NUMBER_OF_TASKS; i++) {
        executorService.submit(() -> {
          for (int j = 0; j < 100; j++) {
            blockingIoOperationContextSwitch();
          }
        });
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
