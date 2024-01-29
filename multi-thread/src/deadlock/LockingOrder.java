package deadlock;

import java.util.Random;

// locking 순서를 유지하면 데드락을 피할 수 있다.
// 그 외의 방법으로는 Watchdog을 사용하는 방법이다.
// Thread Interrupt와 tryLock operation은 synchronized 키워드와 함께 사용할 수 없다는 단점이 있다.
public class LockingOrder {

  public static void execute() {
    Intersection intersection = new Intersection();
    Thread trainAThread = new Thread(new TrainA(intersection));
    Thread trainBThread = new Thread(new TrainB(intersection));
    trainAThread.start();
    trainBThread.start();
  }

  public static class TrainA implements Runnable {
    private Intersection intersection;
    private Random random = new Random();

    public TrainA(Intersection intersection) {
      this.intersection = intersection;
    }

    @Override
    public void run() {
      while(true) {
        long sleepingTime = random.nextInt(5);
        try {
          Thread.sleep(sleepingTime);
        } catch (InterruptedException e) {
        }
        intersection.takeRoadA();
      }
    }
  }

  public static class TrainB implements Runnable {
    private Intersection intersection;
    private Random random = new Random();

    public TrainB(Intersection intersection) {
      this.intersection = intersection;
    }

    @Override
    public void run() {
      while(true) {
        long sleepingTime = random.nextInt(5);
        try {
          Thread.sleep(sleepingTime);
        } catch (InterruptedException e) {
        }
        intersection.takeRoadB();
      }
    }
  }

  public static class Intersection {
    private Object roadA = new Object();
    private Object roadB = new Object();

    public void takeRoadA() {
      // 변경된 부분
      synchronized (roadA) {
        System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

        synchronized (roadB) {
          System.out.println("Train is passing through road A");
          try {
            Thread.sleep(1);
          } catch (InterruptedException e) {
          }
        }
      }
    }

    public void takeRoadB() {
      synchronized (roadA) {
        System.out.println("Road B is locked by thread " + Thread.currentThread().getName());

        synchronized (roadB) {
          System.out.println("Train is passing through road B");
          try {
            Thread.sleep(1);
          } catch (InterruptedException e) {
          }
        }
      }
    }
  }
}
