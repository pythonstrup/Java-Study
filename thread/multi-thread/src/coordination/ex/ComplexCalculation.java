package coordination.ex;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ComplexCalculation {
  public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2)
      throws InterruptedException {
    BigInteger result = BigInteger.ZERO;

    List<PowerCalculatingThread> threads =
        Arrays.asList(new PowerCalculatingThread(base1, power1), new PowerCalculatingThread(base2, power2));

    for (Thread thread: threads) {
      thread.start();
    }

    for (Thread thread: threads) {
      thread.join();
    }

    for (int i = 0; i < threads.size(); i++) {
      PowerCalculatingThread thread = threads.get(i);
      result = result.add(thread.getResult());
    }

    return result;
  }

  private static class PowerCalculatingThread extends Thread {
    private BigInteger result = BigInteger.ONE;
    private BigInteger base;
    private BigInteger power;

    public PowerCalculatingThread(BigInteger base, BigInteger power) {
      this.base = base;
      this.power = power;
    }

    @Override
    public void run() {
      result = pow(base, power);
    }

    private BigInteger pow(BigInteger base, BigInteger power) {
      BigInteger result = BigInteger.ONE;

      for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
        result = result.multiply(base);
      }
      return result;
    }

    public BigInteger getResult() { return result; }
  }
}
