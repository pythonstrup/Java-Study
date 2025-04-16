package cas.increment;

public class BasicInteger implements IncrementInteger {

  private int value;

  @Override
  public void increment() {
    value++; // 원자적이지 않은 연산
  }

  @Override
  public int get() {
    return value;
  }
}
