package collection.blocking.queue;

import static util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BoundedQueueV7 implements BoundedQueue {

  private BlockingQueue<String> queue;

  public BoundedQueueV7(int max) {
    this.queue = new ArrayBlockingQueue<>(max);
  }

  @Override
  public void put(final String data) {
    boolean result = queue.offer(data);
    log("저장 시도 결과 = " + result);
  }

  @Override
  public String take() {
    return queue.poll();
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
