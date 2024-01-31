package coordination;

import java.math.BigInteger;

public class DaemonThread {

  public static void interrupt() throws InterruptedException {
    Thread thread = new Thread(
        new LongComputationTask(new BigInteger("2000000"), new BigInteger(("1000000000"))));
    // Daemon Thread는 메인 스레드가 종료되어도 애플리케이션의 종료를 막지 않는다.
    // 스레드를 Daemon으로 생성하면 앱의 주 작업이 아닌 백그라운드 작업을 맡는다.
    thread.setDaemon(true);
    thread.start();
    thread.sleep(100);
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
        result = result.multiply(base);
      }
      return result;
    }
  }
}
