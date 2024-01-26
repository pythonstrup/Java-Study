import java.io.IOException;
import optimize.latency.ImageRecoloringExecutor;
import race.condition.RaceCondition;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    RaceCondition.execute();
  }

}