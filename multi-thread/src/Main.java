import coordination.DaemonThread;
import coordination.InterruptingThread2;
import coordination.Join;
import coordination.ex.ComplexCalculation;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    BigInteger result = ComplexCalculation.calculateResult(
        new BigInteger("2"),
        new BigInteger("2"),
        new BigInteger("33"),
        new BigInteger("2"));
    System.out.println(result);
  }

}