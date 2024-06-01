package collection.deque;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>(); // 링크드리스트보다 훨씬 빠르다.
//    Queue<Integer> queue = new LinkedList<>();

    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    System.out.println("queue = " + queue);

    System.out.println("queue.peek() = " + queue.peek());

    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue = " + queue);
  }
}
