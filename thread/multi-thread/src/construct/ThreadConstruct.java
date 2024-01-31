package construct;

public class ThreadConstruct {

  public static void thread() {
    Thread thread = new NewThread();

    thread.start();
  }

  public static class NewThread extends Thread {

    @Override
    public void run() {
      System.out.println("Hello from " + Thread.currentThread().getName());
    }
  }
}
