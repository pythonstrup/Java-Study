package reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
  public static final int HIGHEST_PRICE = 1000;

  public static void execute() throws InterruptedException {
    InventoryDatabase inventoryDatabase = new InventoryDatabase();

    Random random = new Random();
    for (int i = 0; i < 100_000; i++) {
      inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
    }

    Thread writer = new Thread(() -> {
      inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
      inventoryDatabase.removeItem(random.nextInt(HIGHEST_PRICE));

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
      }

    });

    writer.setDaemon(true);
    writer.start();

    int numberOfReaderThreads = 7;
    List<Thread> readers = new ArrayList<>();

    for (int readerIndex = 0; readerIndex < numberOfReaderThreads; readerIndex++) {
      Thread reader = new Thread(() -> {
        for (int i = 0; i < 100_000; i++) {
          int upperBoundPrice = random.nextInt(HIGHEST_PRICE);
          int lowerBoundPrice = upperBoundPrice > 0 ? random.nextInt(upperBoundPrice) : 0;
          inventoryDatabase.getNumberOfItemsInPriceRange(lowerBoundPrice, upperBoundPrice);
        }
      });
      reader.setDaemon(true);
      readers.add(reader);
    }

    long startReadingTime = System.currentTimeMillis();
    for (Thread reader: readers) {
      reader.start();
    }
    for (Thread reader: readers) {
      reader.join();
    }

    long endReadingTime = System.currentTimeMillis();
    System.out.println(String.format("Reading took %d ms", endReadingTime - startReadingTime));
  }

  public static class InventoryDatabase {
    private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();
    private ReentrantLock lock = new ReentrantLock(); // => 약 1000~1200ms가 걸린다.
    // Read/Write Lock을 사용하면 400~500ms 정도의 시간만 걸린다.
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = reentrantReadWriteLock.readLock();
    private Lock writeLock = reentrantReadWriteLock.writeLock();

    public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {
//      lock.lock();
      readLock.lock();
      try {
        Integer fromKey = priceToCountMap.ceilingKey(lowerBound);

        Integer toKey = priceToCountMap.floorKey(upperBound);

        if (fromKey == null || toKey == null) {
          return 0;
        }

        NavigableMap<Integer, Integer> rangeOfPrices =
            priceToCountMap.subMap(fromKey, true, toKey, true);

        int sum = 0;
        for (int numberOfItemsForPrice :rangeOfPrices.values()) {
          sum += numberOfItemsForPrice;
        }

        return sum;
      }
      finally {
//        lock.unlock();
        readLock.unlock();
      }
    }

    public void addItem(int price) {
//      lock.lock();
      writeLock.lock();
      try {
        Integer numberOfItemsForPrice = priceToCountMap.get(price);
        if (numberOfItemsForPrice == null) {
          priceToCountMap.put(price, 1);
        } else {
          priceToCountMap.put(price, numberOfItemsForPrice + 1);
        }
      }
      finally {
//        lock.unlock();
        writeLock.unlock();
      }
    }

    public void removeItem(int price) {
//      lock.lock();
      writeLock.lock();
      try {
        Integer numberOfItemsForPrice = priceToCountMap.get(price);
        if (numberOfItemsForPrice == null || numberOfItemsForPrice == 1) {
          priceToCountMap.remove(price);
        } else {
          priceToCountMap.put(price, numberOfItemsForPrice -1);
        }
      }
      finally {
//        lock.unlock();
        writeLock.unlock();
      }
    }
  }
}
