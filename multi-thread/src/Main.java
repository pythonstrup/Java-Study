import java.io.IOException;
import race.condition.SynchronizedBlock;
import race.condition.atomic.operations.AtomicOperations;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    AtomicOperations.execute();
  }

}