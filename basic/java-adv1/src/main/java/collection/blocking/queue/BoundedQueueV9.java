package collection.blocking.queue;

import static util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BoundedQueueV9 implements BoundedQueue {

  private BlockingQueue<String> queue;

  public BoundedQueueV9(int max) {
    this.queue = new ArrayBlockingQueue<>(max);
  }

  @Override
  public void put(final String data) {
    queue.add(data); // java.lang.IllegalStateException: Queue full
  }

  @Override
  public String take() {
    return queue.remove(); // java.util.NoSuchElementException
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
