import java.io.IOException;
import race.condition.non.atomic.NonAtomic;
import race.condition.non.atomic.NonAtomicVolatile;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    NonAtomicVolatile.execute();
  }

}