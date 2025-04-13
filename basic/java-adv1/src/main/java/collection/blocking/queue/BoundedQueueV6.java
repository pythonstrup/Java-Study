package collection.blocking.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BoundedQueueV6 implements BoundedQueue {

  private BlockingQueue<String> queue;

  public BoundedQueueV6(int max) {
    this.queue = new ArrayBlockingQueue<>(max);
  }

  @Override
  public void put(final String data) {
    try {
      queue.put(data);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String take() {
    try {
      return queue.take();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
