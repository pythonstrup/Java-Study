package coordination;

import java.math.BigInteger;

public class InterruptingThread2 {

  public static void interrupt() throws InterruptedException {
    Thread thread = new Thread(
        new LongComputationTask(new BigInteger("2000000"), new BigInteger(("1000000000"))));
    thread.start();
    thread.sleep(100);
    // 인터럽트를 보내도 이를 처리할 메소드나 로직이 없으면 소용이 없다.
    // for문 안에서 인터럽트 당했는지 확인하는 로직이 필요하다.
    thread.interrupt();
  }

  private static class LongComputationTask implements Runnable {

    private final BigInteger base;
    private final BigInteger power;

    public LongComputationTask(BigInteger base, BigInteger power) {
      this.base = base;
      this.power = power;
    }

    @Override
    public void run() {
      System.out.println(base + "^" + power + " = " + pow(base, power));
    }

    private BigInteger pow(BigInteger base, BigInteger power) {
      BigInteger result = BigInteger.ONE;

      for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
        if (Thread.currentThread().isInterrupted()) {
          System.out.println("Prematurely interrupted computation");
          return BigInteger.ZERO;
        }
        result = result.multiply(base);
      }
      return result;
    }
  }
}
