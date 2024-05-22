package generic.ex2;

public class Box<T> {

  private T value;

  public T get() {
    return value;
  }

  public void set(final T value) {
    this.value = value;
  }
}
