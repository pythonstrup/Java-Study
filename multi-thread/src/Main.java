import coordination.DaemonThread;
import coordination.InterruptingThread2;

public class Main {

  public static void main(String[] args) throws InterruptedException {
//    InterruptingThread.interrupt();
//    InterruptingThread2.interrupt();
    DaemonThread.interrupt();
  }

}