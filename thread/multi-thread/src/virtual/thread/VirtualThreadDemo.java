package virtual.thread;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadDemo {

  private static final int NUMBER_OF_VIRTUAL_THREADS = 1_000;

  public static void executePlatformThread() throws InterruptedException {
    Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());

    Thread platformThread = Thread.ofPlatform().unstarted(runnable);

    platformThread.start();
    platformThread.join();
  }

  public static void executeVirtualThread() throws InterruptedException {
    Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());

    List<Thread> virtualThreads = new ArrayList<>();

    for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
      Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
      virtualThreads.add(virtualThread);
    }

    for (Thread virtualThread: virtualThreads) {
      virtualThread.start();
    }

    for (Thread virtualThread: virtualThreads) {
      virtualThread.join();
    }
  }
}
