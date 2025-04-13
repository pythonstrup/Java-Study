package collection.blocking.queue;

public interface BoundedQueue {
  void put(String data);
  String take();
}
