package race.condition;

public class SynchronizedBlock {

  public static void execute() throws InterruptedException {
    InventoryCounter inventoryCounter = new InventoryCounter();
    IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
    DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

    incrementingThread.start();
    decrementingThread.start();

    incrementingThread.join();
    decrementingThread.join();

    // 결과가 매번 달라진다.
    System.out.println("We currently have " + inventoryCounter.getItems() + " items");
  }

  public static class IncrementingThread extends Thread {
    private final InventoryCounter inventoryCounter;

    public IncrementingThread(InventoryCounter inventoryCounter) {
       this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10_000; i++) {
        inventoryCounter.increment();
      }
    }
  }

  public static class DecrementingThread extends Thread {
    private final InventoryCounter inventoryCounter;

    public DecrementingThread(InventoryCounter inventoryCounter) {
      this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10_000; i++) {
        inventoryCounter.decrement();
      }
    }
  }

  private static class InventoryCounter {
    private int items = 0;

    final Object lock = new Object();

    public void increment() {
      synchronized (this.lock) {
        items++;
      }
    }

    public void decrement() {
      synchronized (this.lock) {
        items--;
      }
    }

    public int getItems() {
      synchronized (this.lock) {
        return items;
      }
    }
  }
}
