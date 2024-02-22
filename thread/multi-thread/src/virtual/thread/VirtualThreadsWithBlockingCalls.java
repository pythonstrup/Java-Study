package virtual.thread;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsWithBlockingCalls {

  private static final int NUMBER_OF_VIRTUAL_THREADS = 1_000;

  public static void executeVirtualThread() throws InterruptedException {
    List<Thread> virtualThreads = new ArrayList<>();

    for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
      Thread virtualThread = Thread.ofVirtual().unstarted(new BlockingTask());
      virtualThreads.add(virtualThread);
    }

    for (Thread virtualThread: virtualThreads) {
      virtualThread.start();
    }

    for (Thread virtualThread: virtualThreads) {
      virtualThread.join();
    }
  }

  private static class BlockingTask implements Runnable {

    @Override
    public void run() {
      System.out.println("Inside thread: " + Thread.currentThread());
      try {
        Thread.sleep(1_000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Inside thread: " + Thread.currentThread() + " after blocking call");
    }
  }
}
