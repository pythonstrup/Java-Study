import java.io.IOException;
import reentrantlock.ReadWriteLock;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    ReadWriteLock.execute();
  }

}