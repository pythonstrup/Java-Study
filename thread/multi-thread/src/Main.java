import atomic.AtomicReferenceStackObject;
import atomic.AtomicReferenceStringValue;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    AtomicReferenceStackObject.executeLockFree();
  }

}