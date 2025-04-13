package collection.blocking.queue;

import static util.MyLogger.log;

public class ConsumerTask implements Runnable {

  private BoundedQueue queue;

  public ConsumerTask(final BoundedQueue queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    String data = queue.take();
    log("[소비 시도]     ? <- " + queue);
    log("[소비 완료] " + data + " <- " + queue);
  }
}
