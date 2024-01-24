import java.io.IOException;
import optimize.ImageRecoloringExecutor;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    ImageRecoloringExecutor.singleThread();
    ImageRecoloringExecutor.multiThread();
  }

}